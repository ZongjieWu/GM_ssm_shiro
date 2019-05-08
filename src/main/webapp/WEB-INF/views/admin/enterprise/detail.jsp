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
                <div class="layui-card-header">企业信息</div>
                <div class="layui-card-body" pad15>
                    <div class="layui-form" wid100 lay-filter="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">Logo</label>
                            <div class="layui-input-block">
                                <c:if test="${enterprise.logo==null || enterprise.logo==''}">
                                    <img id="logo" name="logo" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;">
                                </c:if>
                                <c:if test="${enterprise.logo!=null && enterprise.logo!=''}">
                                    <img id="logo" name="logo" src="<%=path%>/${enterprise.logo}" style="width: 7%;height: 14%;">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">名称</label>
                            <div class="layui-input-block">
                                <input type="text" id="name" name="name"   class="layui-input" value="${enterprise.name}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">手机号</label>
                            <div class="layui-input-block">
                                <input type="text" id="phone" name="phone" lay-verify="phone" class="layui-input" value="${enterprise.phone}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-block">
                                <input type="text" id="email" name="email"  class="layui-input"  value="${enterprise.email}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">weChat</label>
                            <div class="layui-input-block">
                                <input type="text" id="weChat" name="weChat"  class="layui-input" value="${enterprise.weChat}">
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">qq</label>
                            <div class="layui-input-block">
                                <input type="text" id="qq" name="qq" class="layui-input" value="${enterprise.qq}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">简介</label>
                            <div class="layui-input-block">
                                <input type="text" id="intro" name="intro" class="layui-input" value="${enterprise.intro}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">上班时间</label>
                            <div class="layui-input-block">
                                <input type="text" id="workTime" name="workTime" class="layui-input" value="${enterprise.workTime}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">单双休</label>
                            <div class="layui-input-block">
                                <c:if test="${enterprise.singleDoubleCease==0}">
                                    <input type="text" id="singleDoubleCease" name="singleDoubleCease" class="layui-input" value="无休息">
                                </c:if>
                                <c:if test="${enterprise.singleDoubleCease==1}">
                                    <input type="text" id="singleDoubleCease" name="singleDoubleCease" class="layui-input" value="单休">
                                </c:if>
                                <c:if test="${enterprise.singleDoubleCease==2}">
                                    <input type="text" id="singleDoubleCease" name="singleDoubleCease" class="layui-input" value="双休">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">企业类型</label>
                            <div class="layui-input-block">
                                <input type="text" id="enterpriseType" name="enterpriseType" class="layui-input" value="${enterprise.enterpriseType}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">企业性质</label>
                            <div class="layui-input-block">
                                <input type="text" id="quality" name="quality" class="layui-input" value="${enterprise.quality}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">企业规模</label>
                            <div class="layui-input-block">
                                <input type="text" id="scale" name="scale" class="layui-input" value="${enterprise.scale}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">状态</label>
                            <div class="layui-input-block">
                                <c:if test="${enterprise.status==0}">
                                    <input type="text"  class="layui-input" value="未审核">
                                </c:if>
                                <c:if test="${enterprise.status==1}">
                                    <input type="text"  class="layui-input" value="审核通过">
                                </c:if>
                                <c:if test="${enterprise.status==2}">
                                    <input type="text"  class="layui-input" value="审核不通过">
                                </c:if>
                                <c:if test="${enterprise.status==3}">
                                    <input type="text"  class="layui-input" value="冻结">
                                </c:if>
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">所在省</label>
                            <div class="layui-input-inline">
                                <input type="text" id="province" name="province" class="layui-input" value="${enterprise.province}">
                            </div>
                            <label class="layui-form-label">市</label>
                            <div class="layui-input-inline">
                                <input type="text" id="city" name="city" class="layui-input" value="${enterprise.city}">
                            </div>
                            <label class="layui-form-label">县</label>
                            <div class="layui-input-inline">
                                <input type="text" id="area" name="area" class="layui-input" value="${enterprise.area}">
                            </div>
                            <label class="layui-form-label">镇</label>
                            <div class="layui-input-inline">
                                <input type="text" id="town" name="town" class="layui-input" value="${user.town}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">详细地址</label>
                            <div class="layui-input-block">
                                <input type="text" id="detailPlace" name="detailPlace" class="layui-input" value="${enterprise.detailPlace}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">精度</label>
                            <div class="layui-input-block">
                                <input type="text" id="lng" name="lng" class="layui-input" value="${enterprise.lng}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">纬度</label>
                            <div class="layui-input-block">
                                <input type="text" id="lat" name="lat" class="layui-input" value="${enterprise.lat}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">法人身份证(正面)</label>
                            <div class="layui-input-block"  id="test2">
                                <c:if test="${enterprise.legalIdCard==null || enterprise.legalIdCard==''}">
                                    <a href="<%=path%>/static/upload/image/blank.jpg" target="_blank"><img id="legalIdCard" name="legalIdCard" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;"></a>
                                </c:if>
                                <c:if test="${enterprise.legalIdCard!=null && enterprise.legalIdCard!=''}">
                                    <a href="<%=path%>/${enterprise.legalIdCard}" target="_blank"><img id="legalIdCard" name="legalIdCard" src="<%=path%>/${enterprise.legalIdCard}" style="width: 7%;height: 14%;"></a>
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">法人身份证(反面)</label>
                            <div class="layui-input-block"  id="test6">
                                <c:if test="${enterprise.legalIdCardReverse==null || enterprise.legalIdCardReverse==''}">
                                    <a target="_blank" href="<%=path%>/static/upload/image/blank.jpg"><img id="legalIdCardReverse" name="legalIdCardReverse" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;"></a>
                                </c:if>
                                <c:if test="${enterprise.legalIdCardReverse!=null && enterprise.legalIdCardReverse!=''}">
                                    <a href="<%=path%>/${enterprise.legalIdCardReverse}" target="_blank"><img id="legalIdCardReverse" name="legalIdCardReverse" src="<%=path%>/${enterprise.legalIdCardReverse}" style="width: 7%;height: 14%;"></a>
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">营业执照</label>
                            <div class="layui-input-block" id="test3">
                                <c:if test="${enterprise.businessLicense==null || enterprise.businessLicense==''}">
                                    <a href="<%=path%>/static/upload/image/blank.jpg" target="_blank"><img id="businessLicense" name="businessLicense" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;"></a>
                                </c:if>
                                <c:if test="${enterprise.businessLicense!=null && enterprise.businessLicense!=''}">
                                    <a href="<%=path%>/${enterprise.businessLicense}" target="_blank"><img id="businessLicense" name="businessLicense" src="<%=path%>/${enterprise.businessLicense}" style="width: 7%;height: 14%;"></a>
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">办学资质</label>
                            <div class="layui-input-block" id="test4">
                                <c:if test="${enterprise.teacherAptitude==null || enterprise.teacherAptitude==''}">
                                    <a href="<%=path%>/static/upload/image/blank.jpg" target="_blank"> <img id="teacherAptitude" name="teacherAptitude" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;"></a>
                                </c:if>
                                <c:if test="${enterprise.teacherAptitude!=null && enterprise.teacherAptitude!=''}">
                                    <a href="<%=path%>/${enterprise.teacherAptitude}" target="_blank"><img id="teacherAptitude" name="teacherAptitude" src="<%=path%>/${enterprise.teacherAptitude}" style="width: 7%;height: 14%;"></a>
                                </c:if>
                            </div>
                        </div>
                        <%--<div class="layui-form-item">--%>
                            <%--<label class="layui-form-label">打款凭证</label>--%>
                            <%--<div class="layui-input-block" id="test5">--%>
                                <%--<c:if test="${enterprise.remitAuthentication==null || enterprise.remitAuthentication==''}">--%>
                                    <%--<img id="remitAuthentication" name="remitAuthentication" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;">--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${enterprise.remitAuthentication!=null && enterprise.remitAuthentication!=''}">--%>
                                    <%--<img id="remitAuthentication" name="remitAuthentication" src="<%=path%>/${enterprise.remitAuthentication}" style="width: 7%;height: 14%;">--%>
                                <%--</c:if>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="la，yui-form-item layui-form-text">
                            <label class="layui-form-label">成立时间</label>
                            <div class="layui-input-block">
                                <input type="text" id="setupTime" name="setupTime" class="layui-input" value="${enterprise.setupTime}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">认证时间</label>
                            <div class="layui-input-block">
                                <input type="text" id="authenticationTime" name="authenticationTime" class="layui-input" value="${enterprise.authenticationTime}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">注册时间</label>
                            <div class="layui-input-block">
                                <input type="text" id="addTime" name="addTime" class="layui-input" value="${enterprise.addTime}">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">上一次修改时间</label>
                            <div class="layui-input-block">
                                <input type="text" id="modifyTime" name="modifyTime" class="layui-input" value="${enterprise.modifyTime}">
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
