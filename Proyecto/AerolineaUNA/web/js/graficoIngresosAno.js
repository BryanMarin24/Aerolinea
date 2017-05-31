
var lineChartData = {
			labels : ["2014","2015","2016","2017"],
			datasets : [
				
				{
					label: "Segunda serie de datos",
					fillColor : "rgba(151,187,205,0.2)",
					strokeColor : "#e9e225",
					pointColor : "#faab12",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(151,187,205,1)",
					data : [10000000,30000000,20000000,4000000]
				}
			]

		}
                
                
                var ctx = document.getElementById("grafico").getContext("2d");
                window.myPie = new Chart(ctx).Line(lineChartData, {responsive:true});
