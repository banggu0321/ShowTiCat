<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</style>
</head>
<body>
<ul class="">
<li class="chart">
	<p class="chartTitle">성별 예매 분포</p>
	<canvas id="myChart" width="500" height="300"></canvas>
</li>
<li class="chart">
	<p class="chartTitle">연령별 예매 분포</p>
	<canvas id="ageChart" width="500" height="300"></canvas>
</li>
</ul>

<script>
const ctx = document.getElementById('ageChart').getContext('2d');
const ageChart = new Chart(ctx, {
    type: 'doughnut',
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
    	legend: false,
    	responsive: false,
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
    	legend: false,
    	responsive: false,
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