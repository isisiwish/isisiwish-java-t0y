#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import json

# 根据原始数据，使用新数据插入，生成新的测试数据
original_json_str = '''
{"floorId":"29052","count":"200","pNum":"0","pSize":"20","tbkClickScene":"optimus@op","variableMap":"{\\"itemid\\":\\"40463392182\\"}"}
'''

dataObj = json.loads(original_json_str)

in_file = open('itemId.txt', 'r')
out_file = open('itemIds.txt','w')

for line in in_file.readlines():  
    line = line.strip('\n')
    originalObj = json.loads(dataObj['variableMap'])
    originalObj['itemid'] = line
    dataObj['variableMap'] = json.dumps(originalObj)
    print(json.dumps(dataObj))
    out_file.write(json.dumps(dataObj))
    out_file.write('\n')

in_file.close()
out_file.close()

s = '''
dataObj = json.loads(data_json_str)
dataList = dataObj['data']['recommend']['resultList']

for data in dataList:
    itemId = data['itemId']
    couponShareUrl = "https:" + data['couponShareUrl']
    parsed = urlparse.urlparse(couponShareUrl)
    e = urlparse.parse_qs(parsed.query)['e']
    if itemId != None or itemId != '':
        originalObj = json.loads(original_json_str)
        originalObj[0]['referer'] = couponShareUrl
        originalObj[0]['variableMap']['itemId'] = itemId
        originalObj[0]['variableMap']['e'] = e

        ofile.write(json.dumps(originalObj))
        ofile.write('\n')

ofile.close()
'''