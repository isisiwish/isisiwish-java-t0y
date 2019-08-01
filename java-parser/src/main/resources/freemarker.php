<?php
if(!defined("ROOT")){
    include_once '../../conf.inc';
}
include_once ROOT . "/inc/facade/YApiClient.inc";
include_once ROOT . "/inc/facade/DDsdkClient.inc";
include_once ROOT . "/inc/facade/ApiResultManager.inc";
include_once ROOT . "/inc/facade/AutoTestManager.inc";


class DangdangOrdersOuterorderidUpdateTest
{
    public function case1()
    {
        $sdkClient = $ddsdkClient->getDDHttpClient(1.0);
    }
    public function case2()
    {
        $sdkClient = $ddsdkClient->getDDHttpClient(2.0);
    }
}


