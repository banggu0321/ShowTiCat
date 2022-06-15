<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels"></script>

<style>
.chart {
	width: 50%;
	float:left;
	text-align: center;
}
.chart p {
	font-size: 18px;
}
#myChart, #ageChart {
	margin: 0 auto;
}
.chartImg{
	position: relative;
}
.man, .woman, .r10, .r20, .r30, .r40, .r50 {
	position: absolute;
	font-weight: bold;
}
.man {
	top:30%;
	right: 10%;
}
.woman {
	top:30%;
	left: 15%;
}
.r10 {
	top: 70%;
	left: 12%;
}
.r20 {
	top: 50%;
	left: 30%;
}
.r30 {
	top: 50%;
	right: 42%;
}
.r40 {
	top: 60%;
	right: 23%;
}
.r50 {
	top: 70%;
	right: 5%;
}
</style>
</head>
<body>
<c:set var="sum" value="${chart.rate_m+chart.rate_w}"/>
<ul class="chartBox">
<li class="chart">
	<div class="chartImg">
		<p class="chartTitle">성별 예매 분포</p>
		<div class="man">남성<br>${Math.round(chart.rate_m/sum*1000)/10}%</div>
		<div class="woman">여성<br>${Math.round(chart.rate_w/sum*1000)/10}%</div>
		<canvas id="myChart" width="500" height="300"></canvas>
	</div>
</li>
<li class="chart">
	<div class="chartImg">
		<p class="chartTitle">연령별 예매 분포</p>
		<%-- 	
		<div class="r10">10대<br>${Math.round(chart.rate_10/sum*1000)/10}%</div>
		<div class="r20">20대<br>${Math.round(chart.rate_20/sum*1000)/10}%</div>
		<div class="r30">30대<br>${Math.round(chart.rate_30/sum*1000)/10}%</div>
		<div class="r40">40대<br>${Math.round(chart.rate_40/sum*1000)/10}%</div>
		<div class="r50">50대<br>${Math.round(chart.rate_50/sum*1000)/10}%</div> 
		--%>
		<canvas id="ageChart" width="500" height="300"></canvas>
	</div>
</li>
</ul>

<script>
const ctx = document.getElementById('ageChart').getContext('2d');
const ageChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['10대', '20대', '30대', '40대', '50대'],
        datasets: [{
            data: [${chart.rate_10}, ${chart.rate_20}, ${chart.rate_30}, ${chart.rate_40}, ${chart.rate_50}],
            backgroundColor: [
                'rgba(255, 99, 132, 0.8)',
                'rgba(54, 162, 235, 0.8)',
                'rgba(255, 206, 86, 0.8)',
                'rgba(167, 96, 255, 0.8)',
                'rgba(255, 159, 64, 0.8)'
            ]
        }]
    },
    options: {
    	responsive: false,
    	legend: {
    		display:false
    	},
        scales: {
        	yAxes: {
       		 gridLines: {
                    lineWidth: 0 //y축 격자선 없애기
                }
       	 	}
        },
        animation: {
            duration: 0
        }
    }
});

const ctx2 = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx2, {
    type: 'doughnut',
    data: {
        labels: ['남', '여'],
        datasets: [{
            data: [${chart.rate_m}, ${chart.rate_w}],
            backgroundColor: [
            	'rgba(54, 162, 235, 0.8)',
            	'rgba(255, 159, 64, 0.8)'
            ]
        }]
    },
    options: {
    	responsive: false,
    	legend: {
    		display:false
    	},
        scales: {
        	 yAxes: {
        		 gridLines: {
                     lineWidth: 0 //y축 격자선 없애기
                 }
        	 }
        },
        animation: {
            duration: 0
        }
    }
});
</script>

</body>
</html>