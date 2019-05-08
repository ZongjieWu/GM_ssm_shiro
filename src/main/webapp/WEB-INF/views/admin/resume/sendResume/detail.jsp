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
                <div class="layui-card-header">用户简历信息</div>
                <div class="layui-card-body" pad15>
                    <div class="layui-form" wid100 lay-filter="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">头像</label>
                            <div class="layui-input-block">
                                <c:if test="${userResume.headImg==null || userResume.headImg==''}">
                                    <img id="headImg" name="headImg" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;">
                                </c:if>
                                <c:if test="${userResume.headImg!=null && userResume.headImg!=''}">
                                    <img id="headImg" name="headImg" src="<%=path%>/${userResume.headImg}" style="width: 7%;height: 14%;">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">名称</label>
                            <div class="layui-input-block">
                                <input type="text" id="name" name="name"   class="layui-input" value="${userResume.name}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">性别</label>
                            <div class="layui-input-block">
                                <input type="text" id="sex" name="sex" lay-verify="sex" class="layui-input" value="${userResume.sex}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">年龄</label>
                            <div class="layui-input-block">
                                <input type="text" id="age" name="age"  class="layui-input"  value="${userResume.age}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">工龄</label>
                            <div class="layui-input-block">
                                <input type="text" id="workAge" name="workAge"  class="layui-input" value="${userResume.workAge}">
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-block">
                                <input type="text" id="email" name="email" class="layui-input" value="${userResume.email}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">期望工资</label>
                            <div class="layui-input-block">
                                <input type="text" id="expectMoney" name="expectMoney" class="layui-input" value="${userResume.expectMoney}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">电话</label>
                            <div class="layui-input-block">
                                <input type="text" id="phone" name="phone" class="layui-input" value="${userResume.phone}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">籍贯</label>
                            <div class="layui-input-block">
                                <input type="text" id="nativePlace" name="nativePlace" class="layui-input" value="${userResume.nativePlace}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">求职状态</label>
                            <div class="layui-input-block">
                                <c:if test="${userResume.findJobStatus==0}">
                                    <input type="text"  class="layui-input" value="离职(随时到岗)">
                                </c:if>
                                <c:if test="${userResume.findJobStatus==1}">
                                    <input type="text"  class="layui-input" value="在职(月内到岗)">
                                </c:if>
                                <c:if test="${userResume.findJobStatus==2}">
                                    <input type="text"  class="layui-input" value="在职(考虑机会)">
                                </c:if>
                                <c:if test="${userResume.findJobStatus==3}">
                                    <input type="text"  class="layui-input" value="在职(暂不考虑)">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">婚姻状态</label>
                            <div class="layui-input-block">
                                <c:if test="${userResume.marriageStatus==0}">
                                    <input type="text"  class="layui-input" value="未婚">
                                </c:if>
                                <c:if test="${userResume.marriageStatus==1}">
                                    <input type="text"  class="layui-input" value="已婚">
                                </c:if>

                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">状态</label>
                            <div class="layui-input-block">
                                <c:if test="${userResume.status==0}">
                                    <input type="text"  class="layui-input" value="关闭">
                                </c:if>
                                <c:if test="${userResume.status==1}">
                                    <input type="text"  class="layui-input" value="开启">
                                </c:if>
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">所在省</label>
                            <div class="layui-input-inline">
                                <input type="text" id="province" name="province" class="layui-input" value="${userResume.province}">
                            </div>
                            <label class="layui-form-label">市</label>
                            <div class="layui-input-inline">
                                <input type="text" id="city" name="city" class="layui-input" value="${userResume.city}">
                            </div>
                            <label class="layui-form-label">县</label>
                            <div class="layui-input-inline">
                                <input type="text" id="area" name="area" class="layui-input" value="${userResume.area}">
                            </div>
                            <label class="layui-form-label">镇</label>
                            <div class="layui-input-inline">
                                <input type="text" id="town" name="town" class="layui-input" value="${userResume.town}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">详细地址</label>
                            <div class="layui-input-block">
                                <input type="text" id="detailPlace" name="detailPlace" class="layui-input" value="${userResume.detailPlace}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">目标职位</label>
                            <div class="layui-input-block">
                                <input type="text" id="jobType" name="jobType" class="layui-input" value="${userResume.jobType}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">工作类型</label>
                            <div class="layui-input-block">
                                <input type="text" id="workType" name="workType" class="layui-input" value="${userResume.workType}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">学历</label>
                            <div class="layui-input-block">
                                <input type="text" id="education" name="education" class="layui-input" value="${userResume.education}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">职业技能</label>
                            <div class="layui-input-block">
                                <textarea id="jobSkill" name="jobSkill" style="height: 50%;width: 100%;">${userResume.jobSkill}</textarea>
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">自我评价</label>
                            <div class="layui-input-block">
                                <textarea id="selfAppraise" name="selfAppraise"  style="height: 50%;width: 100%;">${userResume.selfAppraise}</textarea>
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">添加时间</label>
                            <div class="layui-input-block">
                                <input type="text" id="addTime" name="addTime" class="layui-input" value="${userResume.addTime}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">上一次修改时间</label>
                            <div class="layui-input-block">
                                <input type="text" id="modifyTime" name="addTime" class="layui-input" value="${userResume.modifyTime}">
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
