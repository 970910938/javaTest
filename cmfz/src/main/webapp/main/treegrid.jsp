<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--菜单处理-->
<script type="text/javascript">
    var toolbr = [{
        iconCls: 'icon-add',
        text: "专辑详情",
        handler: function () {
            //alert('专辑详情')
            var rows = $('#treegrid').treegrid("getSelected");
            console.log(rows)
            if(rows.size==null){
                //console.log(rows)
                $("#zjxq").dialog("open")
                $("#zjxq_form").form("load", rows);
                /*---------------------------------------------*/
                console.log(rows.img)
                $("#img").prop("src", rows.img);
            }else{
                alert("选择要查看的专辑")
            }



        }
    }, '-', {
        iconCls: 'icon-help',
        text: "添加专辑",
        handler: function () {
            //alert('添加专辑')
           $("#zhuanji").dialog("open")


        }
    }, '-', {
        iconCls: 'icon-add',
        text: "添加章节",
        handler: function () {
           // alert('添加章节')
            var rows = $('#treegrid').treegrid("getSelected");
            console.log(rows)
            if (rows.children.size == null) {
                $("#addzj").dialog("open")
                /*修改选中时id的值*/
                $("#pid").textbox("setValue", rows.id)
            }else{
                alert("请选择要添加的专辑目录下")
            }
        }
    }, '-', {
        iconCls: 'icon-add',
        text: "下载音频",
        handler: function () {
            //alert('下载音频')
            var row = $("#treegrid").treegrid("getSelected");

            console.log(row.name)
           window.location.href = "${pageContext.request.contextPath}/album/down?url=" + row.url + "&name="+ row.name;
        }
    }]

    $(function () {
        $('#treegrid').treegrid({
            url: '${pageContext.request.contextPath}/album/queryAll',
            idField: 'id',
            treeField: 'name',
            toolbar: toolbr,
            fit: true,
            fitColumns: true,

            onDblClickRow:function() {
                var row = $('#treegrid').treegrid("getSelected");

                /*如果albumId为空，说明是专辑*/
                if(row.size==null){
                    getMessage("请双击音频播放！");
                }else{
                    console.log(row.url)
                    //显示对话框
                    $("#play_dialog").dialog("open");
                    //设置播放路径
                    $("#playAudio").prop("src",row.url);
                    //设置歌曲名
                    //$("#audioTitle").val(row.name);
                }
            },
            columns: [[

                {field: 'name', title: '专辑名称', width: 60, align: 'center'},
                {field: 'size', title: '专辑大小', width: 80, align: 'center'},
                {field: 'url', title: '专辑路径', width: 80, align: 'center'},
                {field: 'time', title: '专辑时长', width: 80, align: 'center'},

            ]]
        });
    })
    //获取消息方法。
    function getMessage(message){
        $.messager.show({
            title:'消息提醒',
            msg:message+'<br/>消息将在5秒后关闭。',
            timeout:5000,
            showType:'slide'
        });
    }

</script>
<>
<table id="treegrid" style="width:600px;height:400px"></table>
<%-- 专辑详情dialog  --%>
<div id="zjxq" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">


    <form id="zjxq_form" method="post">
        <div>
            <label for="name">名称:</label>
            <input class="easyui-textbox" id="name" type="text" name="name"/>
        </div>
        <div>
            <label for="score">分数:</label>
            <input class="easyui-textbox" type="text" id="score" name="score"/>
        </div>
        <div>
            <label for="author">作者:</label>
            <input class="easyui-textbox" type="text" id="author" name="author"/>
        </div>
        <div>
            <label for="count">集数:</label>
            <input class="easyui-textbox" type="text" id="count" name="count"/>
        </div>
        <div>
            <label for="img">封面:</label>
            <img style="width: 100px" id="img" src="">
        </div>
    </form>

</div>

<%-- 添加章节详情 --%>

<div id="addzj" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                  $('#addzj_from').form('submit',{
                  url:'${pageContext.request.contextPath}/album/add'

                  })
				}
			},{
				text:'关闭',
				handler:function(){
                    $('#addzj').dialog('close');
				}
			}]">
    <%-- 章节--%>
    <form id="addzj_from" method="post" enctype="multipart/form-data">
        <div>
            <label for="pid">id:</label>
            <input class="easyui-textbox" value="0" name="pid" id="pid"/>
        </div>
        <div>
            <label for="upload">上传:</label>
            <input class="easyui-filebox" id="upload" name="multipartFile"/>
        </div>

    </form>

</div>

<%-- 添加专辑详情 --%>

<div id="zhuanji" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                  $('#zhuanji_from').form('submit',{
                  url:'${pageContext.request.contextPath}/album/addzhuanji '
                  })
				}
			},{
				text:'关闭',
				handler:function(){
                    $('#zhuanji').dialog('close');
				}
			}]">

    <form id="zhuanji_from" method="post" enctype="multipart/form-data">
        <div>
            <label for="name">专辑名:</label>
            <input class="easyui-textbox" value="0" name="name" id="zjname"/>
        </div>
        <div>
            <label for="score">专辑分数:</label>
            <input class="easyui-textbox" value="0" name="score" id="zjscore"/>
        </div>

        <div>
            <label for="upload">上传专辑:</label>
            <input class="easyui-filebox" id="zjupload" name="multipartFile"/>
        </div>
    </form>
    <div id="play_dialog" class="easyui-dialog" data-options="closed:true" style="width:400px;height: 200px ">
    <audio id="playAudio" src="" controls="controls" autoplay="autoplay"></audio>
    </div>
</div>




