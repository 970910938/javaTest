<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <!--菜单处理-->
        <script type="text/javascript">

        $(function() {
            $('#tt').edatagrid({

                fit: true,
                pagination:true,
               /*定义从服务器对数据进行排序*/
                remoteSort:false,
                /*如果为true，则只允许选择一行。*/
                singleSelect:true,
                /*如果为true，则在同一行中显示数据。设置为true可以提高加载性能*/
                nowrap:false,
                /*真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。*/
                fitColumns:true,
                /*一个URL从远程站点请求数据。*/
                url:"${pageContext.request.contextPath}/broad/queryAll",
                updateUrl:"${pageContext.request.contextPath}/broad/update",
                destroyUrl:"${pageContext.request.contextPath}/broad/delete",
                autoSave:true,

                toolbar: [{
                    iconCls: 'icon-add',
                    text:"添加",
                    handler: function(){
                        //alert('添加按钮')
                        $("#dd").dialog("open")
                    }
                },{
                    text:"修改",
                    iconCls: 'icon-redo',
                    handler: function() {
                        //alert('修改按钮)
                        /*获取第一次选中的行*/
                        var row= $("#tt").edatagrid("getSelected");
                        console.log(row)
                        if(row!=null){
                            var index = $("#tt").edatagrid("getRowIndex",row);
                            console.log(index)
                            $("#tt").edatagrid("editRow",index);
                        }
                    }

                },{
                    text:"删除",
                iconCls: 'icon-remove',
                    handler: function(){
                     //alert('删除按钮')
                        var row= $("#tt").edatagrid("getSelected");
                        console.log(row)
                        if(row==null){
                            alert("选中行")
                        }else {
                            $('#tt').edatagrid('destroyRow');
                        }
                    }
                 },{
                    text:"保存",
                iconCls: 'icon-save',
                    handler: function(){
                    //alert('保存按钮')
                    $("#tt").edatagrid("saveRow")
                }
                 },{
                    text:"自定义导出",
                    iconCls: 'icon-save',
                    handler: function(){
                        //alert('自定义导出')
                        //$("#custom_dialog").dialog("open")

                    }
                }],



            columns:[[
                   // {field:'id',title:'编号',width:80},
                    {field:'title',title:'标题',width:100,editor:"text"},
                    //{field:'imgPath',title:'图片路径',width:80,align:'right'},
                    {field:'des',title:'图片描述',width:80,align:'right',editor:"text"},
                    {field:'status',title:'状态',width:150,editor:"text"},
                    //{field:'date',title:'日期',width:60,align:'center'}
                ]],
                /*定义DataGrid的视图*/
                view: detailview,

                /*返回详细内容*/
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +

                        '<td rowspan=2 style="border:0"> <img src="' + rowData.imgPath +'" style="height:50px;"> </td>' +
                        '<td style="border:0">' +
                        '<p>图片路径: ' + rowData.imgPath + '</p>' +
                        '<p>日期: ' + rowData.date + '</p>' +
                        '</td>' +
                        '</tr></table>';
                },

                /*index：点击的行的索引值，该索引值从0开始*/
                /*row：对应于点击行的记录。*/

            });

            })

    </script>
<table id="tt"></table>
<div id="dd" class="easyui-dialog" title="添加轮播图" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){

                $('#lunbotu').form('submit', {
                 url:'${pageContext.request.contextPath}/broad/add'
                 })
				}
			},{
				text:'关闭',
				handler:function(){
				$('#dd').dialog('close');
				}
			}]">

    <form id="lunbotu" method="post" enctype="multipart/form-data">
        <div>
            <label for="title">标题:</label>
            <input class="easyui-textbox" id="title"  style="width:200px;" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            <label for="des">描述:</label>
            <input class="easyui-textbox" id="des"  style="width:200px;" type="text" name="des" data-options="required:true"/>
        </div>
        <div>
            <label for="status">状态:</label>
            <select id="status" class="easyui-combobox" name="status" style="width:200px;">
                <option value="1">展示</option>
                <option value="0">不展示</option>
            </select>

        </div>
        <div>
            <input class="easyui-filebox" name="img" style="width:300px">
        </div>
    </form>

</div>


