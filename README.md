# zhzhao
zhzhao.top的后台代码

## Bus接口文档
> 所有的无参请求均为GET，有参请求均为POST

### 接口返回示例：
正确：
```$xslt
{
    "repCode": "0000",
    "repMsg": null,
    "datas": "该字段为成功后返回信息，可能是空，或对象，或数组"
}
```
错误：
```$xslt
{
    "repCode": "错误提示码，可以不关注，不是0000均为错误",
    "repMsg": "错误提示信息",
    "datas": null
}
```
分页返回结果：
```$xslt
{
    "repCode": "0000",
    "repMsg": null,
    "datas": [],
    "currentPage": 1,
    "pageSize": 10,
    "totalCount": 0,
    "haveNextPage": false,
    "havePrePage": false,
    "pageCount": 0
}
```

### 接口

#### 1.测试接口

URL
```$xslt
    /bus/test
```
参数
```$xslt
    无
```
注释
 ```$xslt
     无
 ```
返回
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": "请求成功"
}
```

#### 2.获取所有车辆

URL
```$xslt
    /bus/findAll
```
参数
```$xslt
    type: 查询车辆类型，夜班或白班
```
注释
```$xslt
    type的值可为空,或者"night",为空时查询所有白班车辆，为"night"时查询夜班车辆
```
返回
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": [{
             "lineKey": "1", //线路ID
             "lineName": "1", //线路名称
             "regionCode": "bj" //城市编码
             },
             {
                 "lineKey": "2",
                 "lineName": "2",
                 "regionCode": "bj"
             },
             ...
             ]
}
```

####  3.根据车辆名称 查询车辆列表

URL
```
    /bus/findListByName
```
参数
```$xslt
    type: 查询车辆类型，夜班或白班
    name: 车辆名称
```
注释
```$xslt
    type的值可为空,或者"night",为空时查询所有白班车辆，为"night"时查询夜班车辆
    name 为模糊查询
``` 
返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": [{
             "lineKey": "1", //线路ID
             "lineName": "1", //线路名称
             "regionCode": "bj" //地区编码
             },
             {
                 "lineKey": "2",
                 "lineName": "2",
                 "regionCode": "bj"
             },
             ...
             ]
}
```
#### 4.根据线路ID 查询车辆的始发站和终点站

URL
```
    /bus/getLineDir
```
参数
```$xslt
    lineId: 线路ID 必填
```
注释
```$xslt
    无
``` 
返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": [
        {
            "name": "1(老山公交场站-四惠枢纽站)", //线路名称
            "value": "5276138694316562750"  //方向ID
        },
        {
            "name": "1(四惠枢纽站-老山公交场站)",
            "value": "5431016404622390237"
        }
    ]
}
```
#### 5.根据线路ID和方向 查询车辆所有站点

URL
```
    /bus/getDirStation
```
参数
```$xslt
    lineId: 线路ID 必填
    dirId: 方向ID 必填
```
注释
```$xslt
    无
``` 
返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": [
        {
            "name": "老山公交场站",  //站点名称
            "value": "1"            //站点ID
        },
        {
            "name": "老山南路东口",
            "value": "2"
        },
        {
            "name": "地铁八宝山站",
            "value": "3"
        },
        {
            "name": "玉泉路口西",
            "value": "4" 
        },
        {
            "name": "永定路口东",
            "value": "5"
        },
        ......
    ]
}
```

#### 6.根据线路ID,方向ID,站点ID 查询实时信息

URL
```
    /bus/getBusTime
```
参数
```$xslt
    lineId: 线路ID 必填
    dirId: 方向ID 必填
    stopId: 站点ID 必填
```
注释
```$xslt
    无
``` 
返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": {
        "currentStop": "北京西站",      //当前查询站点
        "operationTime": "5:00-23:00",  //该站点运营时间
        "priceType": "分段计价",        //计价方式
        "lastStop": "3",                //最近车辆还有几站
        "lastDistance": 2.5,            //最近车辆距离
        "expectedTime": "6"             //预计到达时间
    }
}
```