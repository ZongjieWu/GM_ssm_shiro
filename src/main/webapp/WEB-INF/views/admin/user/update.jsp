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
                    <div id="from11" class="layui-form" wid100 lay-filter="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">头像</label>
                            <div class="layui-input-block" id="test1">
                                <c:if test="${user.headImg==null || user.headImg==''}">
                                    <img id="headImg" name="headImg" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;">
                                </c:if>
                                <c:if test="${user.headImg!=null && user.headImg!=''}">
                                    <img id="headImg" name="headImg" src="<%=path%>/${user.headImg}" style="width: 7%;height: 14%;">
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
                                <input type="text" id="phone" name="phone" class="layui-input" value="${user.phone}">
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
                                <select id="findJobStatus">
                                    <option value="0">离职</option>
                                    <option value="1">在职(月内到岗)</option>
                                    <option value="2">在职(考虑机会)</option>
                                    <option value="3">在职(暂不考虑)</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">婚姻状态</label>
                            <div class="layui-input-block">
                                <select id="marriageStatus">
                                    <option value="0">未婚</option>
                                    <option value="1">已婚</option>
                                </select>
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
                            <div class="layui-input-inline" style="width:19.5%;" >
                                <select id="province" name="province" lay-filter="province" >
                                    <option value="">请选择省</option>
                                </select>
                            </div>
                            <div class="layui-input-inline" style="width:19.5%;" >
                                <select id="city" name="city" lay-filter="city">
                                    <option value="">请选择</option>
                                </select>
                            </div>
                            <div class="layui-input-inline" style="width:19.5%;" >
                                <select id="area" name="area" lay-filter="area">
                                    <option value="">请选择</option>
                                </select>
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
                            <label class="layui-form-label">身份证</label>
                            <div class="layui-input-block"  id="test2">
                                <c:if test="${user.idCard==null || user.idCard==''}">
                                    <img id="idCard" name="idCard" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;">
                                </c:if>
                                <c:if test="${user.idCard!=null && user.idCard!=''}">
                                    <img id="idCard" name="idCard" src="<%=path%>/${user.idCard}" style="width: 7%;height: 14%;">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">教师资格证</label>
                            <div class="layui-input-block" id="test3">
                                <c:if test="${user.teacherCertification==null || user.teacherCertification==''}">
                                    <img id="teacherCertification" name="teacherCertification" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;">
                                </c:if>
                                <c:if test="${user.teacherCertification!=null && user.teacherCertification!=''}">
                                    <img id="teacherCertification" name="teacherCertification" src="<%=path%>/${user.teacherCertification}" style="width: 7%;height: 14%;">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">个人生活照</label>
                            <div class="layui-input-block" id="test4">
                                <c:if test="${user.lifePicture==null || user.lifePicture==''}">
                                    <img id="lifePicture" name="lifePicture" src="<%=path%>/static/upload/image/blank.jpg" style="width: 7%;height: 14%;">
                                </c:if>
                                <c:if test="${user.lifePicture!=null && user.lifePicture!=''}">
                                    <img id="lifePicture" name="lifePicture" src="<%=path%>/${user.lifePicture}" style="width: 7%;height: 14%;">
                                </c:if>
                            </div>
                        </div>

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
<script src="<%=path%>/static/layuiadmin/citySelect/data.js"></script>
<script src="<%=path%>/static/layuiadmin/citySelect/province.js"></script>
<script>
    var $form;
    var defaults = {
        s1: 'province',
        s2: 'city',
        s3: 'area',
        v1: '${user.province}',
        v2: '${user.city}',
        v3: '${user.area}'
    };
    $(function(){
        $("#findJobStatus").val('${user.findJobStatus}');
        $("#marriageStatus").val('${user.marriageStatus}');
        $("#workExperience").val('${user.workExperience}');
    });
    layui.config({
        base: '<%=path%>/static/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index']);
    var form,layer;
    layui.use(['form','layer','upload'], function(){
        form = layui.form;
        layer =layui.layer;
        upload =layui.upload;

        $form = $('#from11');
        treeSelect(defaults);
        form.on("submit(set_website)",function(res){
            var data={}
            data.id='${user.id}';
            data.headImg=$("#idCard").attr("src").substring(1,$("#idCard").attr("src").length);
            data.name=$("#name").val();
            data.phone=$("#phone").val();
            data.email=$("#email").val();
            data.weChat=$("#weChat").val();
            data.qq=$("#qq").val();
            data.findJobStatus=$("#findJobStatus").val();
            data.marriageStatus=$("#marriageStatus").val();
            data.workExperience=$("#workExperience").val();
            data.age=$("#age").val();
            data.nativePlace=$("#nativePlace").val();
            data.province=$("#province").val();
            data.city=$("#city").val();
            data.area=$("#area").val();
            data.town=$("#town").val();
            data.detailPlace=$("#detailPlace").val();
            data.idCard=$("#idCard").attr("src").substring(1,$("#idCard").attr("src").length);
            data.teacherCertification=$("#teacherCertification").attr("src").substring(1,$("#teacherCertification").attr("src").length);
            data.lifePicture=$("#lifePicture").attr("src").substring(1,$("#lifePicture").attr("src").length);

            $.post("<%=path%>/user/update",data,function(res) {
                if (res.code == 0) {
                    parent.refreshTable(res.msg);
                } else {
                    layer.msg(res.msg);
                }

            });
        });
                //上传头像
        var uploadInst1 = upload.render({
            elem: '#test1'
            ,url: '/upload/image/uploadImg'
            ,data: {
                baseCatalog: "/static/upload/image/user/headImg"
            }
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#headImg').attr('src', "<%=path%>/"+result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code == 0){
                    console.log(res.data);
                    $('#headImg').attr('src', "<%=path%>/"+res.data);
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
        //上传身份证
        var uploadInst2 = upload.render({
            elem: '#test2'
            ,url: '/upload/image/uploadImg'
            ,data: {
                baseCatalog: "/static/upload/image/user/IDCard"
            }
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#idCard').attr('src', "<%=path%>/"+result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code == 0){
                    console.log(res.data);
                    $('#idCard').attr('src', "<%=path%>/"+res.data);
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
        //上传生活照
        var uploadInst3 = upload.render({
            elem: '#test3'
            ,url: '/upload/image/uploadImg'
            ,data: {
                baseCatalog: "/static/upload/image/user/lifePicture"
            }
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#teacherCertification').attr('src', "<%=path%>/"+result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code == 0){
                    console.log(res.data);
                    $('#teacherCertification').attr('src', "<%=path%>/"+res.data);
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
        //上传教师资格证
        var uploadInst4 = upload.render({
            elem: '#test4'
            ,url: '/upload/image/uploadImg'
            ,data: {
                baseCatalog: "/static/upload/image/user/teacherCertification"
            }
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#lifePicture').attr('src',"<%=path%>/"+result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code == 0){
                    console.log(res.data);
                    $('#lifePicture').attr('src',"<%=path%>/"+res.data);
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
