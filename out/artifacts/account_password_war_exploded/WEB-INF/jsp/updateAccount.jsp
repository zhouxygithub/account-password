<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2022/9/16
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <title>更新账号</title>
</head>
<body>
<div style="width: 800px;margin-left: 25%;margin-top: 5%">
    <form>
        <input id="id" value="${account.id}" type="hidden">
        <div class="form-group">
            <label>名称：</label>
            <input type="text" id="name" value="${account.name}" required>
        </div>
        <div class="form-group">
            <label>账号：</label>
            <input type="text" id="account" value="${account.account}" required>
        </div>
        <div class="form-group">
            <label>密码：</label>
            <input type="text" id="password" value="${account.password}" required>
        </div>
        <div class="form-group">
            <label>类型：</label>
            <select id="type">
                <option value="software">软件</option>
                <option value="url">网站</option>
                <option value="other">其他</option>
            </select>
        </div>
        <div class="form-group">
            <label>备注：</label>
            <textarea name="remark" cols="30" rows="10" id="remark">${account.remark}</textarea>
        </div>
        <div class="form-group">
            <input type="submit" id="submit" value="修改">
        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/statics/jquery-3.6.0.js"></script>
<script>
    $(function () {
        $('#submit').click(function () {
            let id = $('#id').val();
            let name = $('#name').val();
            let account = $('#account').val();
            let password = $('#password').val();
            let type = $('#type').val();
            let remark = $('#remark').val();
            let param = {
                'id':id,
                'name':name,
                'account':account,
                'password':password,
                'type':type,
                'remark':remark,
            }
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath}/updateAccount',
                data: param,
                success: function (data) {
                    console.log(data)
                    let parse = JSON.parse(data);
                    if (parse.code == 200){
                        window.location.href = '${pageContext.request.contextPath}/main';
                    }
                }
            })
            console.log(param)
        })
    })
</script>
</body>
</html>
