<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path=request.getContextPath();%>
<html>
<head>
    <meta charset="utf-8">
    <title>网站设置</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link href="/static/common/image/hdrc.jpg" sizes="128x128" rel="shortcut icon" type="image/x-icon" />
    <link href="/static/common/image/hdrc.jpgo" sizes="128x128" rel="shortcut icon" />
    <link rel="stylesheet" href="<%=path%>/static/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=path%>/static/layuiadmin/style/admin.css" media="all">
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">发布职位</div>
                <div class="layui-card-body" pad15>
                    <div class="layui-form" wid100 lay-filter="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">企业名称</label>
                            <div class="layui-input-block">
                                <input type="text" id="enterpriseName" name="enterpriseName"   class="layui-input" value="${issueJob.enterpriseName}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">联系人</label>
                            <div class="layui-input-block">
                                <input type="text" id="contactName" name="contactName" lay-verify="contactName" class="layui-input" value="${issueJob.contactName}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">联系电话</label>
                            <div class="layui-input-block">
                                <input type="text" id="contactPhone" name="contactPhone"  class="layui-input"  value="${issueJob.contactPhone}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">联系微信</label>
                            <div class="layui-input-block">
                                <input type="text" id="contactWechat" name="contactWechat"  class="layui-input" value="${issueJob.contactWechat}">
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">联系qq</label>
                            <div class="layui-input-block">
                                <input type="text" id="contactQq" name="contactQq" class="layui-input" value="${issueJob.contactQq}">
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">联系的邮箱</label>
                            <div class="layui-input-block">
                                <input type="text" id="workExperience" name="workExperience" class="layui-input" value="${issueJob.contactEmail}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">工作地点</label>
                            <div class="layui-input-block">
                                <input type="text" id="workPlace" name="workPlace" class="layui-input" value="${issueJob.workPlace}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">年龄</label>
                            <div class="layui-input-block">
                                <input type="text" id="age" name="age" class="layui-input" value="${issueJob.age}">
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">工龄</label>
                            <div class="layui-input-block">
                                <input type="text" id="workAge" name="workAge" class="layui-input" value="${issueJob.workAge}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">状态</label>
                            <div class="layui-input-block">
                                <c:if test="${user.status==0}">
                                    <input type="text"  class="layui-input" value="在招">
                                </c:if>
                                <c:if test="${user.status==1}">
                                    <input type="text"  class="layui-input" value="急招">
                                </c:if>
                                <c:if test="${user.status==2}">
                                    <input type="text"  class="layui-input" value="停招">
                                </c:if>
                            </div>
                        </div>



                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">发布时间</label>
                            <div class="layui-input-block">
                                <input type="text" id="addTime" name="addTime" class="layui-input" value="${user.addTime}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">更新时间</label>
                            <div class="layui-input-block">
                                <input type="text" id="modifyTime" name="addTime" class="layui-input" value="${user.modifyTime}">
                            </div>
                        </div>
                        <%--<div class="layui-form-item">--%>
                            <%--<div class="layui-input-block">--%>
                                <%--<button class="layui-btn" lay-submit lay-filter="set_website">确认保存</button>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<%=path%>/static/common/jquery.min.js"></script>
<script src="<%=path%>/static/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '<%=path%>/static/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index']);
    var form,layer;
    layui.use(['form','layer'], function(){
        form = layui.form;
        layer =layui.layer;
    });

</script>
</body>
</html>
