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
<head>
    <meta charset="utf-8">
    <title>华顿教师人才</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link href="/static/common/image/hdrc.jpg" sizes="128x128" rel="shortcut icon" type="image/x-icon" />
    <link href="/static/common/image/hdrc.jpgo" sizes="128x128" rel="shortcut icon" />
    <link rel="stylesheet" href="<%=path%>/static/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=path%>/static/layuiadmin/style/admin.css" media="all">
</head>
<body class="layui-layout-body">

<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <!-- 头部区域 -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item layadmin-flexible" lay-unselect>
                    <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="<%=path%>/webSite/findJob.html" target="_blank" title="前台">
                        <i class="layui-icon layui-icon-website"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" layadmin-event="refresh" title="刷新">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>
                <%--<li class="layui-nav-item layui-hide-xs" lay-unselect>--%>
                    <%--<input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach" lay-action="template/search.html?keywords=">--%>
                <%--</li>--%>
            </ul>
            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">

                <%--<li class="layui-nav-item" lay-unselect>--%>
                    <%--<a lay-href="app/message/index.html" layadmin-event="message" lay-text="消息中心">--%>
                        <%--<i class="layui-icon layui-icon-notice"></i>--%>

                        <%--<!-- 如果有新消息，则显示小圆点 -->--%>
                        <%--<span class="layui-badge-dot"></span>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="theme">
                        <i class="layui-icon layui-icon-theme"></i>
                    </a>
                </li>
                <%--<li class="layui-nav-item layui-hide-xs" lay-unselect>--%>
                    <%--<a href="javascript:;" layadmin-event="note">--%>
                        <%--<i class="layui-icon layui-icon-note"></i>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="fullscreen">
                        <i class="layui-icon layui-icon-screen-full"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;">
                        <cite>${admin.phone}</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a lay-href="<%=path%>/admin/jumpInfo">基本资料</a></dd>
                        <dd><a lay-href="set/user/password.html">修改密码</a></dd>
                        <hr>
                        <dd style="text-align: center;"><a href="<%=path%>/admin/logout">退出</a></dd>
                    </dl>
                </li>

                <%--<li class="layui-nav-item layui-hide-xs" lay-unselect>--%>
                    <%--<a href="javascript:;" layadmin-event="about"><i class="layui-icon layui-icon-more-vertical"></i></a>--%>
                <%--</li>--%>
                <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
                    <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
            </ul>
        </div>

        <!-- 侧边菜单 -->
        <div class="layui-side layui-side-menu">
            <div class="layui-side-scroll">
                <div class="layui-logo" lay-href="home/console.html">
                    <span>华顿教师人才</span>
                </div>

                <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
                    <%--<li data-name="home" class="layui-nav-item layui-nav-itemed">--%>
                        <%--<a href="javascript:;" lay-tips="主页" lay-direction="2">--%>
                            <%--<i class="layui-icon layui-icon-home"></i>--%>
                            <%--<cite>主页</cite>--%>
                        <%--</a>--%>
                        <%--<dl class="layui-nav-child">--%>
                            <%--<dd data-name="console" class="layui-this">--%>
                                <%--<a lay-href="home/console.html">控制台</a>--%>
                            <%--</dd>--%>
                            <%--<dd data-name="console">--%>
                                <%--<a lay-href="home/homepage1.html">主页一</a>--%>
                            <%--</dd>--%>
                            <%--<dd data-name="console">--%>
                                <%--<a lay-href="home/homepage2.html">主页二</a>--%>
                            <%--</dd>--%>
                        <%--</dl>--%>
                    <%--</li>--%>
                    <li data-name="component" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="认证管理" lay-direction="2">
                            <i class="layui-icon layui-icon-component"></i>
                            <cite>认证管理</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="button">
                                <a lay-href="<%=path%>/authentication/user/jumpPaging">个人认证</a>
                            </dd>
                            <dd data-name="rate">
                                <a lay-href="<%=path%>/authentication/enterprise/jumpPaging">企业认证</a>
                            </dd>
                            <dd data-name="rate">
                                <a lay-href="<%=path%>/authentication/remit/jumpPaging">充值审核</a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="template" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="用户管理" lay-direction="2">
                            <i class="layui-icon layui-icon-template"></i>
                            <cite>用户管理</cite>
                        </a>
                        <%--<dl class="layui-nav-child">--%>
                            <%--<dd><a lay-href="<%=path%>/user/jumpGeneralPaging">普通用户</a></dd>--%>
                        <%--</dl>--%>
                        <dl class="layui-nav-child">
                            <dd><a lay-href="<%=path%>/user/jumpPaging">认证用户</a></dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd><a lay-href="<%=path%>/user/jumpUnPassPaging">未认证用户</a></dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd><a lay-href="<%=path%>/user/jumpFrostPaging">冻结的用户</a></dd>
                        </dl>
                    </li>
                    <li data-name="app" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="企业管理" lay-direction="2">
                            <i class="layui-icon layui-icon-app"></i>
                            <cite>企业管理</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a lay-href="<%=path%>/enterprise/jumpPaging">认证企业</a></dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd><a lay-href="<%=path%>/enterprise/jumpUnPassPaging">未认证企业</a></dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd><a lay-href="<%=path%>/enterprise/jumpFrostPaging">冻结企业</a></dd>
                        </dl>
                    </li>
                    <li data-name="app" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="简历管理" lay-direction="2">
                            <i class="layui-icon layui-icon-app"></i>
                            <cite>简历管理</cite>
                        </a>
                        <dl class="layui-nav-child">

                            <dd>
                                <a lay-href="<%=path%>/resume/userResume/jumpPaging">用户简历</a>
                            </dd>
                            <dd>
                                <a lay-href="<%=path%>/resume/sendResume/jumpPaging">投递记录</a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="app" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="招聘管理" lay-direction="2">
                            <i class="layui-icon layui-icon-app"></i>
                            <cite>招聘管理</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a lay-href="<%=path%>/invite/issueJob/jumpPaging">发布职位</a>
                            </dd>
                            <dd>
                                <a lay-href="<%=path%>/invite/interviewNotify/jumpPaging">面试邀约</a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="app" class="layui-nav-item">
                        <a lay-href="javascript:;" lay-tips="充值记录" lay-direction="2">
                            <i class="layui-icon layui-icon-app"></i>
                            <cite>充值记录</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a lay-href="<%=path%>/remitRecord/jumpRecordPaging">审核通过</a>
                            </dd>
                            <dd>
                                <a lay-href="<%=path%>/remitRecord/jumpUnPassPaging">审核不通过</a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="app" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="基础设置" lay-direction="2">
                            <i class="layui-icon layui-icon-app"></i>
                            <cite>基础设置</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a lay-href="<%=path%>/enterSet/jumpEnterSet?id=1">入驻费用设置</a>
                            </dd>
                            <dd>
                                <a lay-href="<%=path%>/enterSet/jumpGatheringCodeUpdate">收款码</a>
                            </dd>
                        </dl>
                    </li>
                        <%--<li data-name="app" class="layui-nav-item">--%>
                            <%--<a href="javascript:;" lay-tips="基础设置" lay-direction="2">--%>
                                <%--<i class="layui-icon layui-icon-app"></i>--%>
                                <%--<cite>系统设置</cite>--%>
                            <%--</a>--%>
                            <%--<dl class="layui-nav-child">--%>
                                <%--<dd>--%>
                                    <%--<a lay-href="<%=path%>/enterSet/jumpEnterSet?id=1">数据库备份</a>--%>
                                <%--</dd>--%>
                                <%--<dd>--%>
                                    <%--<a lay-href="javascript:;">菜单管理</a>--%>
                                <%--</dd>--%>
                                <%--<dd>--%>
                                    <%--<a lay-href="javascript:;">权限管理</a>--%>
                                <%--</dd>--%>
                            <%--</dl>--%>
                        <%--</li>--%>
                </ul>
            </div>
        </div>

        <!-- 页面标签 -->
        <div class="layadmin-pagetabs" id="LAY_app_tabs">
            <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-down">
                <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;"></a>
                        <dl class="layui-nav-child layui-anim-fadein">
                            <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                            <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                            <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                    <li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
                </ul>
            </div>
        </div>


        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show">
                <iframe src="<%=path%>/admin/jumpConsole" frameborder="0" class="layadmin-iframe"></iframe>
            </div>
        </div>

        <!-- 辅助元素，一般用于移动设备下遮罩 -->
        <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
</div>
<script src="<%=path%>/static/common/js/jquery.min.js"></script>
<script src="<%=path%>/static/layuiadmin/layui/layui.js"></script>
<script>
    layui.use(['form','layer'], function(){
        var form = layui.form;
        var layer =layui.layer;
        layui.config({
            base: '<%=path%>/static/layuiadmin/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index']);
        <%--form.render();--%>
        <%--//提交--%>
        <%--form.on('submit(LAY-user-login-submit)', function(obj){--%>
            <%--//请求登入接口--%>
            <%--$.post(--%>
                <%--"<%=path%>/admin/login" //实际使用请改成服务端真实接口--%>
                <%--,obj.field--%>
                <%--,function(res) {--%>
                    <%--alert(res.code);--%>
                    <%--if (res.code == 0) {--%>
                        <%--location.href = '<%=path%>/admin/jumpIndex'; //后台主页--%>
                    <%--}--%>
                <%--});--%>

        <%--});--%>
    });
</script>
</body>
</html>

