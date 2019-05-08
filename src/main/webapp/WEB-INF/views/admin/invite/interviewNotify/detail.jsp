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
                <div class="layui-card-header">面试邀约</div>
                <div class="layui-card-body" pad15>
                    <div class="layui-form" wid100 lay-filter="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名称</label>
                            <div class="layui-input-block">
                                <input type="text" id="userName" name="userName"   class="layui-input" value="${interviewNotify.userName}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户电话</label>
                            <div class="layui-input-block">
                                <input type="text" id="userPhone" name="userPhone" lay-verify="userPhone" class="layui-input" value="${interviewNotify.userPhone}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">企业名称</label>
                            <div class="layui-input-block">
                                <input type="text" id="enterpriseName" name="enterpriseName"  class="layui-input"  value="${interviewNotify.enterpriseName}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">通知内容</label>
                            <div class="layui-input-block">
                               <textare id="content" name="content" style="height:50%;width:100%;">${interviewNotify.content}</textare>
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">联系电话</label>
                            <div class="layui-input-block">
                                <input type="text" id="concatPhone" name="concatPhone" class="layui-input" value="${interviewNotify.concatPhone}">
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">面试时间</label>
                            <div class="layui-input-block">
                                <input type="text" id="workExperience" name="workExperience" class="layui-input" value="${interviewNotify.interviewTime}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">状态</label>
                            <div class="layui-input-block">
                                <c:if test="${interviewNotify.status==0}">
                                    <input type="text" id="status" name="status" class="layui-input" value="未处理">
                                </c:if>
                                <c:if test="${interviewNotify.status==1}">
                                    <input type="text" id="status" name="status" class="layui-input" value="准备面试">
                                </c:if>
                                <c:if test="${interviewNotify.status==2}">
                                    <input type="text" id="status" name="status" class="layui-input" value="已面试">
                                </c:if>
                                <c:if test="${interviewNotify.status==3}">
                                    <input type="text" id="status" name="status" class="layui-input" value="面试通过">
                                </c:if>
                                <c:if test="${interviewNotify.status==4}">
                                    <input type="text" id="status" name="status" class="layui-input" value="等通知">
                                </c:if>
                                <c:if test="${interviewNotify.status==5}">
                                    <input type="text" id="status" name="status" class="layui-input" value="未通过">
                                </c:if>
                                <c:if test="${interviewNotify.status==6}">
                                    <input type="text" id="status" name="status" class="layui-input" value="忽视">
                                </c:if>
                            </div>
                        </div>


                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">邀请时间</label>
                            <div class="layui-input-block">
                                <input type="text" id="addTime" name="addTime" class="layui-input" value="${interviewNotify.addTime}">
                            </div>
                        </div>
                      <%--  <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="set_website">确认保存</button>
                            </div>
                        </div>--%>
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
