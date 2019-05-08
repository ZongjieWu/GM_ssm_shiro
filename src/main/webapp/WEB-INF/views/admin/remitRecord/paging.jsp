<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path=request.getContextPath();%>
<html>
<head>
    <meta charset="utf-8">
    <title>layuiAdmin 网站用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link href="/static/common/image/hdrc.jpg" sizes="128x128" rel="shortcut icon" type="image/x-icon" />
    <link href="/static/common/image/hdrc.jpgo" sizes="128x128" rel="shortcut icon" />
    <link rel="stylesheet" href="<%=path%>/static/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=path%>/static/layuiadmin/style/admin.css" media="all">
    <style>
        /*
       *筛选条件向右浮动
       */
        .toRight{
            float: right;
            display: inline;
        }
        /*
        *单元格居中对齐
        */
        .layui-table-cell{
            height: 56px;
            line-height: 56px;
        }
        .layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
            top: 50%;
            transform: translateY(-50%);
        }
        /*
       *工具栏下右对齐
       */
        .layui-form-item .layui-inline {
            margin-bottom: 0;
            margin-right: 0;
        }
        /*
        *调整工具栏按钮图标
        */
        .layui-card-header .layui-icon{
            right: 78%;
            top:43%;
            left:3%;
        }
        /*
         *调整工具栏字体
         */
        .toolFont{
            margin-left: 10%;
        }
        /*
       *行操作对齐
       */
        .layui-btn+.layui-btn {
            margin-left: 0;
        }
    </style>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-form layui-card-header layuiadmin-card-header-auto">
            <div class="layui-form-item">
                <%--<div class="layui-inline">--%>
                <%--<button class="layui-btn layuiadmin-btn-useradmin" data-type="add">添加</button>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                    <%--<a class="layui-btn layui-btn-normal layuiadmin-btn-useradmin" data-type="batchPass"><i class="layui-icon layui-icon-ok"></i><span class="toolFont">批量通过</span></a>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                    <%--<a class="layui-btn layui-btn-danger layuiadmin-btn-useradmin" data-type="unBatchPass"><i class="layui-icon layui-icon-close"></i><span class="toolFont">批量不通过</span></a>--%>
                <%--</div>--%>
                <div class="toRight">
                    <%--<div class="layui-inline selectDiv">--%>
                    <%--<select name="sex">--%>
                    <%--<option value="">性别</option>--%>
                    <%--<option value="1">男</option>--%>
                    <%--<option value="2">女</option>--%>
                    <%--</select>--%>
                    <%--</div>--%>
                    <div class="layui-inline">
                        <input type="text" id="keywords" name="keywords" placeholder="请输入姓名或电话" autocomplete="off" class="layui-input" style="width: 400px;">
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn" lay-submit lay-filter="search">
                            <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                        </button>
                    </div>
                </div>

            </div>
        </div>

        <div class="layui-card-body">
            <table id="demo" lay-filter="demo"></table>
            <script type="text/html" id="imgTpl">
                {{#if (d.enterpriseLogo==null || d.enterpriseLogo == '') { }}
                <img style="display: inline-block; width: 50%; height: 100%;" src= "<%=path%>/static/upload/image/blank.jpg">
                {{# } }}
                {{#if (d.enterpriseLogo!=null && d.enterpriseLogo != '' ) { }}
                <img style="display: inline-block; width: 50%; height: 100%;" src= "<%=path%>/{{ d.enterpriseLogo }}">
                {{# } }}
            </script>
            <script type="text/html" id="remitAuthenticationTpl">
                {{#if (d.remitAuthentication==null || d.remitAuthentication == '') { }}
                <img style="display: inline-block; width: 50%; height: 100%;" src= "<%=path%>/static/upload/image/blank.jpg">
                {{# } }}
                {{#if (d.remitAuthentication!=null && d.remitAuthentication != '' ) { }}
                <img style="display: inline-block; width: 50%; height: 100%;" src= "<%=path%>/{{ d.remitAuthentication }}">
                {{# } }}
            </script>
            <script type="text/html" id="table-useradmin-webuser">
                <%--<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-search"></i>查看</a>--%>
                <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="pass"><i class="layui-icon layui-icon-ok"></i>通过</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="unPass"><i class="layui-icon layui-icon-close"></i>不通过</a>
            </script>
            <script type="text/html" id="statusTpl">
                {{#if (d.status == 0) { }}
                未审核
                {{# } }}
                {{#if (d.status == 1) { }}
                审核通过
                {{# } }}
                {{#if (d.status == 2) { }}
                审核不通过
                {{# } }}
            </script>
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

    var form,layer,table,popUpBox;
    layui.use(['form','layer','table'], function(){
        form = layui.form;
        layer =layui.layer;
        table =layui.table;


        //表格渲染
        table.render({
            elem: '#demo'
            // ,height: 700
            ,url: '<%=path%>/remitRecord/paging' //数据接口
            ,method:"post"
            ,where: {status: 1}
            ,page: true //开启分页
            ,limit:10
            ,limits:[10,20,30,40,50]
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'id',width:"10%",  align:'center', title: 'ID'}
                ,{field: 'enterpriseLogo',width:"12%",  align:'center', title: '头像'
                    ,templet:"#imgTpl"
                }
                ,{field: 'enterpriseName',width:"12%",  align:'center', title: '企业名称'
//                    ,templet:"#nameDemo"
                }
                ,{field: 'enterprisePhone' ,width:"12%",align:'center', title: '企业账号'}
                ,{field: 'remitAuthentication' ,width:"13%",align:'center', title: '打款凭证',templet:"#remitAuthenticationTpl"}
                ,{field: 'serviceType' ,width:"13%",align:'center', title: '服务类型'}
                ,{field: 'status' ,width:"10%",align:'center', title: '审核状态',templet:"#statusTpl"}
                ,{field: 'addTime' ,align:'center', title: '申请时间'}
//                ,{field: '',align:'center',width:'10%', title: '余额'
//                    ,templet:function (row) {return (row.money+row.fictitiousMoney).toFixed(2);}
//                }
//                ,{align:'center', title: '操作',fixed: 'right',templet:"#table-useradmin-webuser"}
            ]]
        });

        //事件
        var active = {
            batchPass: function(){
                var checkStatus = table.checkStatus('demo')
                    ,checkData = checkStatus.data; //得到选中的数据
                if(checkData.length === 0){
                    return layer.msg('请选择数据');
                }
                var ids="";
                for(var i=0;i<checkData.length;i++){
                    if(i<checkData.length-1){
                        ids+=checkData[i].id+","
                    }else{
                        ids+=checkData[i].id
                    }
                }
                layer.confirm("确定通过吗?",function(resdata){
                    $.post('<%=path%>/enterprise/batchUpdate',{ids:ids,status:1},
                        function (res) {
                            if (res.code==0){
                                refreshTable();
                                layer.msg("成功");
                            }else {
                                layer.msg("失败");
                            }
                        });
                });
            }
            ,unBatchPass: function(){
                var checkStatus = table.checkStatus('demo')
                    ,checkData = checkStatus.data; //得到选中的数据

                if(checkData.length === 0){
                    return layer.msg('请选择数据');
                }
                var ids="";
                for(var i=0;i<checkData.length;i++){
                    if(i<checkData.length-1){
                        ids+=checkData[i].id+","
                    }else{
                        ids+=checkData[i].id
                    }
                }
                layer.confirm("确定不通过吗?",function(resdata){
                    $.post('<%=path%>/enterprise/batchUpdate',{ids:ids,status:2},
                        function (res) {
                            if (res.code==0){
                                refreshTable();
                                layer.msg("成功");
                            }else {
                                layer.msg("失败");
                            }
                        });
                });
            }
        };
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            // 查看详情
            if (obj.event === 'detail') {
                popUpBox = layer.open({
                    type: 2,
                    area: ['100%', '100%'],
                    fixed:false,
                    maxmin: true,
                    title: '企业详情',
                    content:'<%=path%>/enterprise/jumpDetail?id='+data.id
                })
            }
            // 通过
            if (obj.event === 'pass') {
                $.post("<%=path%>/api/enterSet/all",function(res){
                    var html='';
                    html+='<form class="layui-form">';
                    html+='<div class="layui-form-item" style="width:80%;margin-top:5%;">';
                    html+='<label class="layui-form-label">年</label>';
                    html+='<input id="id" type="hidden"  value="'+data.id+'"/>';
                    html+='<select id="enterSet" style="display: inline;margin-top: 4%;height: 23%;">';
                    for(var i=0,count=res.data.enterSet.length;i<count;i++){
                        html+='<option value="'+res.data.enterSet[i].money+"/"+res.data.enterSet[i].type+'">'+res.data.enterSet[i].money+"/"+res.data.enterSet[i].type+'年'+'</option>'
                    }
                    html+='</select>';
                    html+='</div>';
                    html+='<div class="layui-form-item"  style="width:80%;">';
                    html+='<div class="layui-input-block" >';
                    html+='<button class="layui-btn" style="margin-left: 10%;" onclick="selectServiceType();">立即提交</button>';
                    html+='</div>';
                    html+='</div>';
                    html+='</form>';

                    popUpBox = layer.open({
                        type: 1,
                        area: ['20%', '20%'],
                        fixed:false,
//                    maxmin: true,
                        title: '选择服务类型',
                        content:html
                    })

                });

            }
            // 拒绝
            if (obj.event === 'unPass') {
                layer.confirm("确定不通过吗?",function(resdata){
                    $.post('<%=path%>/remitRecord/update',{id:data.id,status:2},
                        function (res) {
                            if (res.code==0){
                                refreshTable();
                                layer.msg("成功");
                            }else {
                                layer.msg("失败");
                            }
                        });
                });
            }
        });
        //监听搜索
        form.on('submit(search)', function(data){
            var keywords = $("#keywords").val();
            var data={};
            data.keywords=keywords;
            //执行重载
            table.reload('demo', {
                where: data //设定异步数据接口的额外参数
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });
//        form.on("submit(selectServiceType)",function(){
//
//        });
        $('.layui-btn.layuiadmin-btn-useradmin').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });
    function selectServiceType() {
        $.post('<%=path%>/remitRecord/update',{id:$("#id").val(),serviceType:$("#enterSet").val(),status:1},
            function (res) {
                if (res.code==0){
                    refreshTable();
                    layer.msg("成功");
                }else {
                    layer.msg("失败");
                }
            });
    }
    function refreshTable() {
        table.reload("demo");
        layer.closeAll();
    }

    //    function refreshTable(msg) {
    //        table.reload("demo");
    //        layer.closeAll();
    //        layer.msg(msg)
    //    }
</script>
</body>
</html>
