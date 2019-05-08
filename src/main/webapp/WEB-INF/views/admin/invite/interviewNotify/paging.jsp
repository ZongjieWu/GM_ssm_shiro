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

        /**
    *单个操作按钮
    */
        .layui-btn-xs{
            margin-top:8%;
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
                <%--<a class="layui-btn layui-btn-normal layuiadmin-btn-useradmin" data-type="batchPass"><i class="layui-icon layui-icon-ok"></i>批量通过</a>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                    <%--<a class="layui-btn layui-btn-danger layuiadmin-btn-useradmin" data-type="batchFrost"><i class="layui-icon layui-icon-delete"></i><span class="toolFont">批量冻结</span></a>--%>
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
                {{#if (d.headImg==null || d.headImg == '') { }}
                <img style="display: inline-block; width: 50%; height: 100%;" src= "<%=path%>/static/upload/image/blank.jpg">
                {{# } }}
                {{#if (d.headImg!=null && d.headImg != '' ) { }}
                <img style="display: inline-block; width: 50%; height: 100%;" src= "<%=path%>/{{ d.headImg }}">
                {{# } }}
            </script>
            <script type="text/html" id="table-useradmin-webuser">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-search"></i>查看</a>
                <%--<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="update"><i class="layui-icon layui-icon-edit"></i>编辑</a>--%>
                <%--<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="frost"><i class="layui-icon layui-icon-delete"></i>冻结</a>--%>
            </script>
            <script type="text/html" id="findJobStatusTpl">
                {{#if (d.findJobStatus == 0) { }}
                离职-随时到岗
                {{# } }}
                {{#if (d.findJobStatus == 1) { }}
                在职-月内到岗
                {{# } }}
                {{#if (d.findJobStatus == 2) { }}
                在职-考虑机会
                {{# } }}
                {{#if (d.findJobStatus == 3) { }}
                在职-暂不考虑
                {{# } }}
            </script>
            <script type="text/html" id="statusTpl">
                {{#if (d.status == 0) { }}
                未处理
                {{# } }}
                {{#if (d.status == 1) { }}
                准备面试
                {{# } }}
                {{#if (d.status == 2) { }}
                已面试
                {{# } }}
                {{#if (d.status == 3) { }}
                面试通过
                {{# } }}
                {{#if (d.status == 4) { }}
                等通知
                {{# } }}
                {{#if (d.status == 5) { }}
                未通过
                {{# } }}
                {{#if (d.status == 6) { }}
                忽视
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
            ,url: '<%=path%>/interviewNotify/paging' //数据接口
            ,method:"post"
            ,where: {status: 1}
            ,page: true //开启分页
            ,limit:10
            ,limits:[10,20,30,40,50]
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'id',width:"10%",  align:'center', title: 'ID'}
                ,{field: 'userName' ,width:"10%",align:'center', title: '用户名称'}
                ,{field: 'userPhone' ,width:"10%",align:'center', title: '用户电话'}
                ,{field: 'jobName',width:"10%",  align:'center', title: '职位名称'
//                    ,templet:"#nameDemo"
                }
//                ,{field: 'jobMoney' ,width:"10%",align:'center', title: '职位工资'}
                ,{field: 'enterpriseName',width:"10%",  align:'center', title: '企业名称'
//                    ,templet:"#imgTpl"
                }
//                ,{field: 'workPlace' ,width:"10%",align:'center', title: '工作地点'}

                ,{field: 'interviewTime' ,width:"10%",align:'center', title: '面试时间'}
                ,{field: 'status' ,width:"10%",align:'center', title: '状态',templet:"#statusTpl"}
                ,{field: 'addTime' ,width:"12%",align:'center', title: '注册时间'}
//                ,{field: '',align:'center',width:'10%', title: '余额'
//                    ,templet:function (row) {return (row.money+row.fictitiousMoney).toFixed(2);}
//                }
                ,{align:'center', title: '操作',fixed: 'right',templet:"#table-useradmin-webuser"}
            ]]
        });

        //事件
        var active = {
            batchFrost: function(){
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
                layer.confirm("确定冻结吗?",function(resdata){
                    $.post('<%=path%>/userResume/batchUpdate',{ids:ids,status:3},
                        function (res) {
                            if (res.code==0){
                                refreshTable(res.msg);
                            }else {
                                layer.msg(res.msg);
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
                    title: '发布职位详情',
                    content:'<%=path%>/invite/interviewNotify/jumpDetail?id='+data.id
                })
            }
            // 通过
            if (obj.event === 'update') {
                popUpBox = layer.open({
                    type: 2,
                    area: ['100%', '100%'],
                    fixed:false,
                    maxmin: true,
                    title: '企业修改',
                    content:'<%=path%>/userResume/jumpUpdate?id='+data.id
                })
            }
            // 拒绝
            if (obj.event === 'frost') {
                layer.confirm("确定冻结吗?",function(resdata){
                    $.post('<%=path%>/userResume/update',{id:data.id,status:3},
                        function (res) {
                            if (res.code==0){
                                refreshTable(res.msg);
                            }else {
                                layer.msg(res.msg);
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
        $('.layui-btn.layuiadmin-btn-useradmin').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });

    function refreshTable(msg) {
        table.reload("demo");
        layer.closeAll();
        if(msg!=undefined){
            layer.msg(msg)
        }
    }
</script>
</body>
</html>
