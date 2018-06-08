<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--菜单处理-->
<script type="text/javascript">
    var toolbr = [{
        iconCls: 'icon-add',
        text: "自定义导出文件",
        handler: function () {
            $("#custom_dialog").dialog("open")
        }
    }, '-', {
        iconCls: 'icon-help',
        text: "导入文件",
        handler: function () {
            $("#import_person").dialog("open")
        }
    }]

    $(function () {
        $('#persontreegrid').treegrid({
            url: '${pageContext.request.contextPath}/person/queryAll',
            idField: 'id',
            treeField: 'name',
            toolbar: toolbr,
            fit: true,
            fitColumns: true,

            columns: [[
                {field: 'id', title: '编号', width: 60, align: 'center'},
                {field: 'phoneNum', title: '电话', width: 80, align: 'center'},
                {field: 'username', title: '姓名', width: 80, align: 'center'},
                {field: 'password', title: '密码', width: 80, align: 'center'},
                {field: 'salt', title: '盐值', width: 60, align: 'center'},
                {field: 'dharmaName', title: '法名', width: 80, align: 'center'},
                {field: 'province', title: '省份', width: 80, align: 'center'},
                {field: 'city', title: '城市', width: 80, align: 'center'},
                {field: 'sex', title: '性别', width: 60, align: 'center'},
                {field: 'sign', title: '签名', width: 80, align: 'center'},
                {field: 'headPic', title: '头像', width: 80, align: 'center'},
                {field: 'date', title: '日期', width: 80, align: 'center'},
                {field: 'status', title: '状态', width: 80, align: 'center'},

            ]]
        });
        $("#btn").click(function () {
            //  提交form表单
            var titles = $("#customer_cc").combotree("getText");
            var value = $("#customer_cc").combotree("getValues");
            //var c = "";
            /* $.each(value, function (index, title) {
             if (index != value.length - 1) {
             c += title + ",";
             console.log(index+"--"+c)
             } else {
             c += title;
             console.log(index+"--"+c)
             }
             })*/
            //console.log(value)
            $('#customer_form').form('submit', {
                queryParams: {"titles": titles, "fileds": value},
                url:"${pageContext.request.contextPath}/person/customerExport"
            });
        })
        $("#import_btn").click(function () {

        $('#import_form').form('submit', {
            url:"${pageContext.request.contextPath}/person/importExport"
        })
        })
    })


</script>
<table id="persontreegrid" style="width:600px;height:400px"></table>
<div id="custom_dialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="customer_form" method="post">
        <select id="customer_cc" class="easyui-combotree" style="width:200px;"
                data-options="url:'${pageContext.request.contextPath}/main/comboTree.json',required:true,checkbox:true,onlyLeafCheck:true,multiple:true"></select>
    </form>
    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">确认导出</a>
</div>

<div id="import_person" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="import_form" method="post" enctype="multipart/form-data">
            <input class="easyui-filebox" type="file" name="multipartFile"/>
    </form>
    <a id="import_btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">确认导入</a>
</div>







