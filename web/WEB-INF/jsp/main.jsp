<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>账号密码管理系统</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        a{
            text-decoration: none;
            color: black;
            font-family: 宋体;
            font-weight: bold;
        }
        a:hover{
            color: deepskyblue;
        }
        .t1{
            width: 100%;
            height: 50px;
            background: white;
        }
        .t2{
            width: 100%;
            height: 93%;
            background: #e8e8e8;
        }

    </style>
</head>
<body>
<div class="t1">
    <div>
        账户密码管理系统
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/toAddAccount">添加账号</a>
    </div>
</div>
<div class="t2">
    <div class="col-md-12 column">
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th>类型</th>
                <th>名称</th>
                <th>账号</th>
                <th>密码</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="content">
                <c:forEach var="account" items="${accounts}" varStatus="vs">
                    <tr>
                        <td>${account.type}</td>
                        <td>${account.name}</td>
                        <td>${account.account}</td>
                        <td>${account.password}</td>
                        <td>${account.remark}</td>
                        <td>
                            <button>
                                <a href="${pageContext.request.contextPath}/toUpdateAccount/${account.id}">修改</a>
                            </button>
                            <button>
                                <a href="${pageContext.request.contextPath}/toUpdateAccount/${account.id}">删除</a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>