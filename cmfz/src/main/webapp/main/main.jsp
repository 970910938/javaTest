<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>

    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        <!--菜单处理-->
        $(function () {

            $.ajax({
                url: "${pageContext.request.contextPath}/user/catagory",
                dataType:"text",
                success: function (result) {
                    var menus = $.parseJSON(result);
                   // console.log(result)
                    menus.forEach(function (menu) {
                        var c="";
                        //console.log(menu.childern)
                        $.each(menu.childern,function(index1,cmenu){
                            c+="<p style=\"text-align: center;\"><a onclick=\"addTabs('"+cmenu.title+"','"+cmenu.url+"','"+cmenu.iconCls+"')\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search',width:'210px'\">"+cmenu.title+"</a></p>";
                            //console.log(c)
                        })
                        $('#aa').accordion('add', {
                            title: menu.title,
                            content: c,

                        });
                    });
                }
            })
            $("#modfiy").click(function () {
                    $("#modfiydialog").dialog("open")
            })

            $("#modfiydialog").dialog({
                closed:true,
                title:"修改密码",
                buttons:[{
                    text:'保存',
                    handler:function(){
                        var newpassword = $("#newpassword").val();
                        var oldpassword = $("#oldpassword").val();
                        var password = "${sessionScope.admin1.password}";
                        if(password==oldpassword){
                            $.ajax({
                                url:"${pageContext.request.contextPath}/admin/modfiy",

                                data:{
                                    password:newpassword
                                },
                                success:function (result) {
                                    console.log(result)
                                    if(result.trim()=="success".trim()){
                                        window.location.href="${pageContext.request.contextPath}/login.jsp"
                                    //url:"${pageContext.request.contextPath}/login.jsp"
                                    }
                                    $("#modfiydialog").dialog("close")
                                }
                            })

                        }else{
                            alert("与原密码不一致")
                        }

                    }
                }]
            })
            $("#logout").click(function () {
                console.log("yidianji")
                window.location.href="${pageContext.request.contextPath}/admin/logout"
            })

        })
        function addTabs(title,url){
            var flag = $("#tt").tabs("exists",title);
            if(flag){
                $("#tt").tabs("select",title)
            }else {
                $("#tt").tabs("add", {
                    title: title,
                    href:"${pageContext.request.contextPath}"+url,
                    closable: true,
                    selected:title
                })
            }
        }


    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        持名法州后台管理系统
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin1.name}
        &nbsp;<a  id="modfiy" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a id="logout" href="#"
                                                                                                              class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a>
    </div>
    <div id="modfiydialog">

        <form id="ff" method="post">

                原密码<input class="easyui-textbox" id="oldpassword" name="oldpassword" type="text" data-options="iconCls:'icon-man'" style="width:300px"/>


                新密码<input class="easyui-textbox" id="newpassword" name="newpassword" type="password" data-options="iconCls:'icon-search'" style="width:300px"/>

        </form>
    </div>




</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;百知教育 htf@zparkhr.com.cn</div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <div id="aa" class="easyui-accordion" data-options="fit:true">

    </div>
</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
</body>
</html>