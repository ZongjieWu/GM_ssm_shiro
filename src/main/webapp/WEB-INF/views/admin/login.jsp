<%--
  Created by IntelliJ IDEA.
  User: Zachary
  Date: 2019/3/15
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path=request.getContextPath();%>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>后台登入 - 华顿教师人才</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link href="/static/common/image/hdrc.jpg" sizes="128x128" rel="shortcut icon" type="image/x-icon" />
    <link href="/static/common/image/hdrc.jpgo" sizes="128x128" rel="shortcut icon" />
    <link rel="stylesheet" href="<%=path%>/static/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=path%>/static/layuiadmin/style/admin.css" media="all">
    <link id="layuicss-layer" rel="stylesheet" href="<%=path%>/static/layuiadmin/layui/css/modules/layer/default/layer.css" media="all">
    <!--自己添加的-->
    <link rel="stylesheet" href="<%=path%>/static/layuiadmin/style/login.css" media="all">
    <style>
        .layui-form-checkbox span{
            height: 3%;
        }
    </style>
</head>
<body layadmin-themealias="default">

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>华顿教师人才后台管理系统</h2>
            <p>Management System</p>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="phone"></label>
                <input type="text" name="phone" id="phone" lay-verify="required" placeholder="手机号" class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="pwd"></label>
                <input type="password" name="pwd" id="pwd" lay-verify="required" placeholder="密码" class="layui-input">
            </div>
            <%--<div class="layui-form-item">--%>
                <%--<div class="layui-row">--%>
                    <%--<div class="layui-col-xs7">--%>
                        <%--<label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>--%>
                        <%--<input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">--%>
                    <%--</div>--%>
                    <%--<div class="layui-col-xs5">--%>
                        <%--<div style="margin-left: 10px;">--%>
                            <%--<img src="<%=path%>/static/layuiadmin/captcha" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="layui-form-item" style="margin-bottom: 20px;">--%>
                <%--<input type="checkbox" name="remember" lay-skin="primary" title="记住密码"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><span>记住密码</span><i class="layui-icon layui-icon-ok"></i></div>--%>
                <%--<a href="<%=path%>/admin/jumpForgetPage" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">忘记密码？</a>--%>
            <%--</div>--%>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="LAY-user-login-submit">登 入</button>
            </div>
            <%--<div class="layui-trans layui-form-item layadmin-user-login-other">--%>
                <%--<label>社交账号登入</label>--%>
                <%--<a href="javascript:;"><i class="layui-icon layui-icon-login-qq"></i></a>--%>
                <%--<a href="javascript:;"><i class="layui-icon layui-icon-login-wechat"></i></a>--%>
                <%--<a href="javascript:;"><i class="layui-icon layui-icon-login-weibo"></i></a>--%>
                <%--<a href="<%=path%>/admin/jumpRegister" class="layadmin-user-jump-change layadmin-link">注册帐号</a>--%>
            <%--</div>--%>
        </div>
    </div>

    <div class="layui-trans layadmin-user-login-footer" style="position: static;">

        <p>© 2019 <a href="http://www.jxhuadun.cn/" target="_blank">jxhuadun.cn</a></p>
        <p>华顿教师人才有限公司版权所有</p>
        <p>推荐使用IE8以上浏览器</p>
        <%--<p>--%>
            <%--<span><a href="http://www.layui.com/admin/#get" target="_blank">获取授权</a></span>--%>
            <%--<span><a href="http://www.layui.com/admin/pro/" target="_blank">在线演示</a></span>--%>
            <%--<span><a href="http://www.layui.com/admin/" target="_blank">前往官网</a></span>--%>
        <%--</p>--%>
    </div>

    <!--<div class="ladmin-user-login-theme">
      <script type="text/html" template>
        <ul>
          <li data-theme=""><img src="{{ layui.setter.base }}style/res/bg-none.jpg"></li>
          <li data-theme="#03152A" style="background-color: #03152A;"></li>
          <li data-theme="#2E241B" style="background-color: #2E241B;"></li>
          <li data-theme="#50314F" style="background-color: #50314F;"></li>
          <li data-theme="#344058" style="background-color: #344058;"></li>
          <li data-theme="#20222A" style="background-color: #20222A;"></li>
        </ul>
      </script>
    </div>-->

</div>

<script src="<%=path%>/static/common/js/jquery.min.js"></script>
<script src="<%=path%>/static/layuiadmin/layui/layui.js"></script>
<script>
    layui.use(['form','layer'], function(){
        var form = layui.form;
        var layer =layui.layer;
        form.render();
        //提交
        form.on('submit(LAY-user-login-submit)', function(obj){
            //请求登入接口
            $.post(
                "<%=path%>/admin/login" //实际使用请改成服务端真实接口
                ,obj.field
                ,function(res) {
                if (res.code == 0) {
                    layer.msg(res.msg);
                    location.href = '<%=path%>/admin/jumpIndex'; //后台主页
                }else{
                    layer.msg(res.msg);
                }
            });

        });

    });
</script>

<style id="LAY_layadmin_theme">.layui-side-menu,.layadmin-pagetabs .layui-tab-title li:after,.layadmin-pagetabs .layui-tab-title li.layui-this:after,.layui-layer-admin .layui-layer-title,.layadmin-side-shrink .layui-side-menu .layui-nav>.layui-nav-item>.layui-nav-child{background-color:#20222A !important;}.layui-nav-tree .layui-this,.layui-nav-tree .layui-this>a,.layui-nav-tree .layui-nav-child dd.layui-this,.layui-nav-tree .layui-nav-child dd.layui-this a{background-color:#009688 !important;}.layui-layout-admin .layui-logo{background-color:#20222A !important;}</style><div class="layui-layer-move"></div></body></html>