<%--
  Created by IntelliJ IDEA.
  User: skl
  Date: 2018/6/4
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/js/china.js"></script>
<a id="btn1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">导出用户信息</a>
<script type="text/javascript">
    var arr1=[];
    $(function () {
        $.ajax({
            dataType:"json",
            url:"${pageContext.request.contextPath}/person/query",
            success:function (data) {
                var myChart = echarts.init(document.getElementById('chinamap'));
                option = {
                    title : {
                        text: 'iphone销量',
                        subtext: '纯属虚构',
                        left: 'center'
                    },
                    tooltip : {
                        trigger: 'item'
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data:['iphone5']
                    },
                    visualMap: {
                        min: 0,
                        max: 2500,
                        left: 'left',
                        top: 'bottom',
                        text:['高','低'],           // 文本，默认为数值文本
                        calculable : true
                    },
                    toolbox: {
                        show: true,
                        orient : 'vertical',
                        left: 'right',
                        top: 'center',
                        feature : {
                            mark : {show: true},
                            dataView : {show: true, readOnly: false},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    series : [
                        {
                            name: 'iphone3',
                            type: 'map',
                            mapType: 'china',
                            roam: false,
                            label: {
                                normal: {
                                    show: false
                                },
                                emphasis: {
                                    show: true
                                }
                            },
                            data:data.boy,
                        }
                    ]
                };
                myChart.setOption(option);
            }
        })



    })

</script>
<div id="chinamap" style="width: 1000px;height:700px;"></div>




