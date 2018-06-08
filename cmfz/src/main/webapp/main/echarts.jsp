<%--
  Created by IntelliJ IDEA.
  User: skl
  Date: 2018/6/3
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 400px;height:300px;"></div>

<script type="text/javascript">
    var arr = [];
    var arr1 =[];
    $(function () {
        $.ajax({
            type: "post",
            async: false, //同步执行
            url: "${pageContext.request.contextPath}/album/echarts",
            dataType: "json", //返回数据形式为json
            success: function (result) {
                //console.log(res)
                $.each(result,function (index,value) {
                   console.log(value.number+"--"+value.name)
                    arr.push(value.name)
                    arr1.push(value.number)
                })
            }
        })
    })
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '专辑详情图'
        },
        tooltip: {},
        legend: {
            data: ['销量','个数']

        },
        xAxis: {
            data: arr
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: arr1,
        },{
            name: '个数',
            type: 'line',
            data: arr1,
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

</script>
