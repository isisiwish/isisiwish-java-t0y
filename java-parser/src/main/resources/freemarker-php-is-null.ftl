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
        ${'$'}sdkClient = ${'$'}ddsdkClient->getDDHttpClient(${method.sdkVersion!"1.0"});
    }
    </#list>
}


