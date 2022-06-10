<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels"></script>
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
	<canvas id="myChart" width="300" height="300"></canvas>
</li>
<li class="chart">
	<p>연령별 예매 분포</p> <hr>
	<canvas id="ageChart" width="300" height="300"></canvas>
</li>
<!-- <li class="chart">
	<p>테스트</p> <hr>
	<canvas id="testChart" width="300" height="300"></canvas>
	<div id="js_lll"></div>
</li> -->
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

/* var chart;

function DoughnutChart(data) {
	var doughnutOptions = {
		tooltips: {
			enabled: false
		},
		legend: {
			display: false
		},
		plugins: {
			datalabels: {
				formatter: (value,ctx) => {
					let datasets = cts.chart.data.datasets[0].data;
					if(value!=0) {
						let sum = 0;
						dataArr = ctx.chart.data.datasets[0].data;
						dataArr.map(data => {
							sum += parseInt(data);
						});
						let percentage = Math.round((value*100/sum))+"%";
						return percentage;
					} else {
						let percentage="";
						return percentage;
					}
				},
				color:'#fff',
			}
		}
	};
	
	vat data = {
		type: 'doughnut',
		data: {
	        labels: ['남', '여'],
	        datasets: [{
	            data: [${chart.rate_m}, ${chart.rate_w}],
	            backgroundColor: [
	            	'rgba(54, 162, 235, 0.8)',
	            	'rgba(255, 159, 64, 0.8)'
	            ]
	        }],
	},
	options: doughnutOptions
};

	if(chart) {
		chart.destory();
		chart = new Chart($("#testChart"),data);
	} else {
		chart = new Chart($("#testChart"),data);	
	}
	
	$("#js_lll").html(chart.generateLegend());
}; */
</script>
</body>
</html>