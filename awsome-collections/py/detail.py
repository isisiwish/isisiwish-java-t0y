#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import json

original_json_str = '''
{"floorId":"29428","count":"200","pNum":"0","pSize":"20","tbkClickScene":"optimus@op","variableMap":"{\\"couponActivityId\\":\\"253e37cc5de44b3ebfdab06b8924a50b\\",\\"sellerId\\":\\"2219509495\\",\\"itemId\\":\\"596668952682\\",\\"pageType\\":\\"agent\\"}"}
'''

dataObj = json.loads(original_json_str)

in_file = open('itemId.txt', 'r')
out_file = open('details.txt','w')

for line in in_file.readlines():  
    line = line.strip('\n')
    originalObj = json.loads(dataObj['variableMap'])
    originalObj["itemId"] = line
    dataObj['variableMap'] = json.dumps(originalObj)
    print(json.dumps(dataObj))
    out_file.write(json.dumps(dataObj))
    out_file.write('\n')

in_file.close()
out_file.close()
