<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
.chart {
	float:left;
	list-style: none;
	padding: 5px 50px 10px 5px;
	text-align: center;
}
</style>
</head>
<body>
<ul>
<li class="chart">
	<p>성별 예매 분포</p> <hr>
	<canvas id="myChart2" width="300" height="300"></canvas>
</li>
<li class="chart">
	<p>연령별 예매 분포</p> <hr>
	<canvas id="myChart" width="300" height="300"></canvas>
</li>
</ul>

<script>
const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
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
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(167, 96, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 0
        }]
    },
    options: {
    	legend: {
            display: false
        },
    	responsive: false,
        scales: {
            y: {
                beginAtZero: true
            }
        },
        animation: {
            duration: 0
        }
    }
});

const ctx2 = document.getElementById('myChart2').getContext('2d');
const myChart2 = new Chart(ctx2, {
    type: 'doughnut',
    data: {
        labels: ['남', '여'],
        datasets: [{
            data: [${chart.rate_m}, ${chart.rate_w}],
            backgroundColor: [
            	'rgba(54, 162, 235, 0.8)',
            	'rgba(255, 159, 64, 0.8)'
            ],
            borderColor: [
            	'rgba(54, 162, 235, 1)',
            	'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 0
        }]
    },
    options: {
    	legend: {
            display: false
        },
    	responsive: false,
        scales: {
            y: {
                beginAtZero: true
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