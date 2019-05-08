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
                <div class="layui-card-header">用户信息</div>
                <div class="layui-card-body" pad15>
                    <div class="layui-form" wid100 lay-filter="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">头像</label>
                            <div class="layui-input-block">
                                <c:if test="${user.headImg==null || user.headImg==''}">
                                    <a href="<%=path%>/static/upload/image/blank.jpg" target="_blank"><img id="headImg" name="headImg" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;"></a>
                                </c:if>
                                <c:if test="${user.headImg!=null && user.headImg!=''}">
                                    <a href="<%=path%>/${user.headImg}"  target="_blank"><img id="headImg" name="headImg" src="<%=path%>/${user.headImg}" style="width: 7%;height: 14%;"></a>
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">名称</label>
                            <div class="layui-input-block">
                                <input type="text" id="name" name="name"   class="layui-input" value="${user.name}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">手机号</label>
                            <div class="layui-input-block">
                                <input type="text" id="phone" name="phone" lay-verify="phone" class="layui-input" value="${user.phone}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-block">
                                <input type="text" id="email" name="email"  class="layui-input"  value="${user.email}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">weChat</label>
                            <div class="layui-input-block">
                                <input type="text" id="weChat" name="weChat"  class="layui-input" value="${user.weChat}">
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">qq</label>
                            <div class="layui-input-block">
                                <input type="text" id="qq" name="qq" class="layui-input" value="${user.qq}">
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">求职状态</label>
                            <div class="layui-input-block">
                                <c:if test="${user.findJobStatus==0}">
                                    <input type="text"  class="layui-input" value="离职(随时到岗)">
                                </c:if>
                                <c:if test="${user.findJobStatus==1}">
                                    <input type="text"  class="layui-input" value="在职(月内到岗)">
                                </c:if>
                                <c:if test="${user.findJobStatus==2}">
                                    <input type="text"  class="layui-input" value="在职(考虑机会)">
                                </c:if>
                                <c:if test="${user.findJobStatus==3}">
                                    <input type="text"  class="layui-input" value="在职(暂不考虑)">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">婚姻状态</label>
                            <div class="layui-input-block">
                                <c:if test="${user.marriageStatus==0}">
                                    <input type="text"  class="layui-input" value="未婚">
                                </c:if>
                                <c:if test="${user.marriageStatus==1}">
                                    <input type="text"  class="layui-input" value="已婚">
                                </c:if>

                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">状态</label>
                            <div class="layui-input-block">
                                <c:if test="${user.status==0}">
                                    <input type="text"  class="layui-input" value="未审核">
                                </c:if>
                                <c:if test="${user.status==1}">
                                    <input type="text"  class="layui-input" value="审核通过">
                                </c:if>
                                <c:if test="${user.status==2}">
                                    <input type="text"  class="layui-input" value="审核不通过">
                                </c:if>
                                <c:if test="${user.status==3}">
                                    <input type="text"  class="layui-input" value="冻结">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">工作年龄</label>
                            <div class="layui-input-block">
                                <input type="text" id="workExperience" name="workExperience" class="layui-input" value="${user.workExperience}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">年龄</label>
                            <div class="layui-input-block">
                                <input type="text" id="age" name="age" class="layui-input" value="${user.age}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">籍贯</label>
                            <div class="layui-input-block">
                                <input type="text" id="nativePlace" name="nativePlace" class="layui-input" value="${user.nativePlace}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">所在省</label>
                            <div class="layui-input-inline">
                                <input type="text" id="province" name="province" class="layui-input" value="${user.province}">
                            </div>
                            <label class="layui-form-label">市</label>
                            <div class="layui-input-inline">
                                <input type="text" id="city" name="city" class="layui-input" value="${user.city}">
                            </div>
                            <label class="layui-form-label">县</label>
                            <div class="layui-input-inline">
                                <input type="text" id="area" name="area" class="layui-input" value="${user.area}">
                            </div>
                            <label class="layui-form-label">镇</label>
                            <div class="layui-input-inline">
                                <input type="text" id="town" name="town" class="layui-input" value="${user.town}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">详细地址</label>
                            <div class="layui-input-block">
                                <input type="text" id="detailPlace" name="detailPlace" class="layui-input" value="${user.detailPlace}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">身份证(正面)</label>
                            <div class="layui-input-block"  id="test2">
                                <c:if test="${user.idCard==null || user.idCard==''}">
                                    <a href="<%=path%>/static/upload/image/blank.jpg" target="_blank"><img id="idCard" name="idCard" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;"></a>
                                </c:if>
                                <c:if test="${user.idCard!=null && user.idCard!=''}">
                                    <a href="<%=path%>/${user.idCard}" target="_blank"><img id="idCard" name="idCard" src="<%=path%>/${user.idCard}" style="width: 7%;height: 14%;"></a>
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">身份证(反面)</label>
                            <div class="layui-input-block"  id="test6">
                                <c:if test="${user.idCardReverse==null || user.idCardReverse==''}">
                                    <a href="<%=path%>/static/upload/image/blank.jpg" target="_blank"><img id="idCardReverse" name="idCardReverse" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;"></a>
                                </c:if>
                                <c:if test="${user.idCardReverse!=null && user.idCardReverse!=''}">
                                    <a href="<%=path%>/${user.idCardReverse}" target="_blank"><img id="idCardReverse" name="idCardReverse" src="<%=path%>/${user.idCardReverse}" style="width: 7%;height: 14%;"></a>
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">教师资格证</label>
                            <div class="layui-input-block" id="test3">
                                <c:if test="${user.teacherCertification==null || user.teacherCertification==''}">
                                    <a href="<%=path%>/static/upload/image/blank.jpg" target="_blank"><img id="teacherCertification" name="teacherCertification" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;"></a>
                                </c:if>
                                <c:if test="${user.teacherCertification!=null && user.teacherCertification!=''}">
                                    <a href="<%=path%>/${user.teacherCertification}" target="_blank"><img id="teacherCertification" name="teacherCertification" src="<%=path%>/${user.teacherCertification}" style="width: 7%;height: 14%;"></a>
                                </c:if>
                            </div>
                        </div>
                        <%--<div class="layui-form-item">--%>
                            <%--<label class="layui-form-label">个人生活照</label>--%>
                            <%--<div class="layui-input-block" id="test4">--%>
                                <%--<c:if test="${user.lifePicture==null || user.lifePicture==''}">--%>
                                    <%--<img id="lifePicture" name="lifePicture" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;">--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${user.lifePicture!=null && user.lifePicture!=''}">--%>
                                    <%--<img id="lifePicture" name="lifePicture" src="<%=path%>/${user.lifePicture}" style="width: 7%;height: 14%;">--%>
                                <%--</c:if>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">认证时间</label>
                            <div class="layui-input-block">
                                <input type="text" id="authenticationTime" name="addTime" class="layui-input" value="${user.authenticationTime}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">注册时间</label>
                            <div class="layui-input-block">
                                <input type="text" id="addTime" name="addTime" class="layui-input" value="${user.addTime}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">上一次修改时间</label>
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
