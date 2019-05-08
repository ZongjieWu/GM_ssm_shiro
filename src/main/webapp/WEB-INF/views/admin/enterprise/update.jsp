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
                            <div class="layui-input-block" id="test1">
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
                                <input type="text" id="phone" name="phone"  class="layui-input" value="${enterprise.phone}">
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
                                <select  id="singleDoubleCease">
                                    <option value="0">无休息</option>
                                    <option value="1">单休</option>
                                    <option value="2">双休</option>
                                </select>
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
                        <%--<div class="layui-form-item layui-form-text">--%>
                            <%--<label class="layui-form-label">状态</label>--%>
                            <%--<div class="layui-input-block">--%>
                                <%--<c:if test="${enterprise.status==0}">--%>
                                    <%--<input type="text"  class="layui-input" value="未审核">--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${enterprise.status==1}">--%>
                                    <%--<input type="text"  class="layui-input" value="审核通过">--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${enterprise.status==2}">--%>
                                    <%--<input type="text"  class="layui-input" value="审核不通过">--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${enterprise.status==3}">--%>
                                    <%--<input type="text"  class="layui-input" value="冻结">--%>
                                <%--</c:if>--%>
                            <%--</div>--%>
                        <%--</div>--%>

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
                                <input type="text" id="town" name="town" class="layui-input" value="${enterprise.town}">
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
                            <label class="layui-form-label">法人身份证</label>
                            <div class="layui-input-block"  id="test2">
                                <c:if test="${enterprise.legalIdCard==null || enterprise.legalIdCard==''}">
                                    <img id="legalIdCard" name="legalIdCard" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;">
                                </c:if>
                                <c:if test="${enterprise.legalIdCard!=null && enterprise.legalIdCard!=''}">
                                    <img id="legalIdCard" name="legalIdCard" src="<%=path%>/${enterprise.legalIdCard}" style="width: 7%;height: 14%;">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">营业执照</label>
                            <div class="layui-input-block" id="test3">
                                <c:if test="${enterprise.businessLicense==null || enterprise.businessLicense==''}">
                                    <img id="businessLicense" name="businessLicense" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;">
                                </c:if>
                                <c:if test="${enterprise.businessLicense!=null && enterprise.businessLicense!=''}">
                                    <img id="businessLicense" name="businessLicense" src="<%=path%>/${enterprise.businessLicense}" style="width: 7%;height: 14%;">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">办学资质</label>
                            <div class="layui-input-block" id="test4">
                                <c:if test="${enterprise.teacherAptitude==null || enterprise.teacherAptitude==''}">
                                    <img id="teacherAptitude" name="teacherAptitude" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;">
                                </c:if>
                                <c:if test="${enterprise.teacherAptitude!=null && enterprise.teacherAptitude!=''}">
                                    <img id="teacherAptitude" name="teacherAptitude" src="<%=path%>/${enterprise.teacherAptitude}" style="width: 7%;height: 14%;">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">打款凭证</label>
                            <div class="layui-input-block" id="test5">
                                <c:if test="${enterprise.remitAuthentication==null || enterprise.remitAuthentication==''}">
                                    <img id="remitAuthentication" name="remitAuthentication" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;">
                                </c:if>
                                <c:if test="${enterprise.remitAuthentication!=null && enterprise.remitAuthentication!=''}">
                                    <img id="remitAuthentication" name="remitAuthentication" src="<%=path%>/${enterprise.remitAuthentication}" style="width: 7%;height: 14%;">
                                </c:if>
                            </div>
                        </div>
                        <%--<div class="layui-form-item layui-form-text">--%>
                            <%--<label class="layui-form-label">注册时间</label>--%>
                            <%--<div class="layui-input-block">--%>
                                <%--<input type="text" id="addTime" name="addTime" class="layui-input" value="${enterprise.addTime}">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="layui-form-item layui-form-text">--%>
                            <%--<label class="layui-form-label">上一次修改时间</label>--%>
                            <%--<div class="layui-input-block">--%>
                                <%--<input type="text" id="modifyTime" name="modifyTime" class="layui-input" value="${enterprise.modifyTime}">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="set_website">确认保存</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<%=path%>/static/common/jquery.min.js"></script>
<script src="<%=path%>/static/layuiadmin/layui/layui.js"></script>
<script>
    $(function () {
        $("#singleDoubleCease").val('${enterprise.singleDoubleCease}');
    });
    layui.config({
        base: '<%=path%>/static/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index']);
    var form,layer,upload;
    layui.use(['form','layer','upload'], function(){
        form = layui.form;
        layer =layui.layer;
        upload =layui.upload;

        form.on("submit(set_website)",function(res){
            var data={}
            data.id='${enterprise.id}';
            data.logo=$("#logo").attr("src").substring(1,$("#logo").attr("src").length);
            data.name=$("#name").val();
            data.phone=$("#phone").val();
            data.email=$("#email").val();
            data.weChat=$("#weChat").val();
            data.qq=$("#qq").val();
            data.intro=$("#intro").val();
            data.workTime=$("#workTime").val();
            data.singleDoubleCease=$("#singleDoubleCease").val();
            data.enterpriseType=$("#enterpriseType").val();
            data.quality=$("#quality").val();
            data.scale=$("#scale").val();
            data.province=$("#province").val();
            data.city=$("#city").val();
            data.area=$("#area").val();
            data.town=$("#town").val();
            data.detailPlace=$("#detailPlace").val();
            data.lng=$("#lng").val();
            data.lat=$("#lat").val();
            data.legalIdCard=$("#legalIdCard").attr("src").substring(1,$("#legalIdCard").attr("src").length);
            data.businessLicense=$("#businessLicense").attr("src").substring(1,$("#businessLicense").attr("src").length);
            data.teacherAptitude=$("#teacherAptitude").attr("src").substring(1,$("#teacherAptitude").attr("src").length);
            data.remitAuthentication=$("#remitAuthentication").attr("src").substring(1,$("#remitAuthentication").attr("src").length);

            $.post("<%=path%>/enterprise/update",data,function(res) {
                if (res.code == 0) {
                    parent.refreshTable(res.msg);
                } else {
                    layer.msg(res.msg);
                }

            });
        });

        //上传logo
        var uploadInst1 = upload.render({
            elem: '#test1'
            ,url: '/upload/image/uploadImg'
            ,data: {
                baseCatalog: "/static/upload/image/enterprise/logo"
            }
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#logo').attr('src', "<%=path%>/"+result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code == 0){
                    console.log(res.data);
                    $('#logo').attr('src', "<%=path%>/"+res.data);
                    return layer.msg('上传成功');
                }else{
                    return layer.msg('上传失败');
                }
                //上传成功
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
        //上传法人身份证
        var uploadInst2 = upload.render({
            elem: '#test2'
            ,url: '/upload/image/uploadImg'
            ,data: {
                baseCatalog: "/static/upload/image/enterprise/legalIdCard"
            }
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#legalIdCard').attr('src', "<%=path%>/"+result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code == 0){
                    console.log(res.data);
                    $('#legalIdCard').attr('src', "<%=path%>/"+res.data);
                    return layer.msg('上传成功');
                }else{
                    return layer.msg('上传失败');
                }
                //上传成功
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
        //上传营业执照
        var uploadInst3 = upload.render({
            elem: '#test3'
            ,url: '/upload/image/uploadImg'
            ,data: {
                baseCatalog: "/static/upload/image/enterprise/businessLicense"
            }
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#businessLicense').attr('src', "<%=path%>/"+result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code == 0){
                    console.log(res.data);
                    $('#businessLicense').attr('src', "<%=path%>/"+res.data);
                    return layer.msg('上传成功');
                }else{
                    return layer.msg('上传失败');
                }
                //上传成功
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
        //上传办学资质
        var uploadInst4 = upload.render({
            elem: '#test4'
            ,url: '/upload/image/uploadImg'
            ,data: {
                baseCatalog: "/static/upload/image/enterprise/teacherAptitude"
            }
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#teacherAptitude').attr('src',"<%=path%>/"+result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code == 0){
                    console.log(res.data);
                    $('#teacherAptitude').attr('src',"<%=path%>/"+res.data);
                    return layer.msg('上传成功');
                }else{
                    return layer.msg('上传失败');
                }
                //上传成功
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
        //上传打款凭证
        var uploadInst5 = upload.render({
            elem: '#test5'
            ,url: '/upload/image/uploadImg'
            ,data: {
                baseCatalog: "/static/upload/image/enterprise/remitAuthentication"
            }
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#remitAuthentication').attr('src',"<%=path%>/"+result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code == 0){
                    console.log(res.data);
                    $('#remitAuthentication').attr('src',"<%=path%>/"+res.data);
                    return layer.msg('上传成功');
                }else{
                    return layer.msg('上传失败');
                }
                //上传成功
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
    });

</script>
</body>
</html>
