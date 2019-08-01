<?php
if(!defined("ROOT")){
    include_once '../../conf.inc';
}
include_once ROOT . "/inc/facade/YApiClient.inc";
include_once ROOT . "/inc/facade/DDsdkClient.inc";
include_once ROOT . "/inc/facade/ApiResultManager.inc";
include_once ROOT . "/inc/facade/AutoTestManager.inc";


class ${TestInfo.className}
{
    <#list TestInfo.methodList as method>
    public function ${method.name}()
    {
        ${'$'}apiResponse = YApiClient::get(${method.caseId});

        ${'$'}ddsdkClient = new DDsdkClient();
        ${'$'}sdkClient = ${'$'}ddsdkClient->getDDHttpClient(${method.sdkVersion});
        ${'$'}${method.requestName} = new ${method.requestName}();
        // TODO request set
        ${'$'}sdkResponse = ${'$'}sdkClient->execute(${'$'}${method.requestName});

        ${'$'}apiResultManager = new ApiResultManager();
        ${'$'}result = $apiResultManager->compareApiResult($apiResponse, $sdkResponse);
        return ${'$'}result;
    }
    </#list>
}

${'$'}${TestInfo.className} = new ${TestInfo.className}();

<#list TestInfo.methodList as method>
${'$'}result = ${'$'}${TestInfo.className}->${method.name}();
</#list>

<#list TestInfo.methodList as method>
echo ${'$'}result."\r\n";
print_r("------------------------------------------------------------------"."\r\n");
</#list>
