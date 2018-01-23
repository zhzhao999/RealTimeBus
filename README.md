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

1. 测试接口

URL:
	`/bus/test`

参数:
 	无
 
注释:
 	无

返回:
```
{
    "repCode": "0000",
    "repMsg": null,
    "datas": "请求成功"
}
```
