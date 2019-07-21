pipeline{
    agent{
    	node any;
    }
    stages{
        stage("Clean"){
            steps{
    			deleteDir();            
            }
        }
        stage("Checkout"){
            steps{
	            checkout([
	            	$class: 'GitSCM',
	            	branches: [[name: '*/master']],
	            	doGenerateSubmoduleConfigurations: false,
	            	extensions: [],
	            	submoduleCfg: [], 
	            	userRemoteConfigs: [[
	            		credentialsId: '4d46b568-a99f-4b9e-8fdb-1ac30e25582a',
	            		url: 'https://github.com/GourishVashisht/MockitoAndJunit5'
	               		]
	            	]
	            ])
            }
        }
        stage("Build and Run Unit Tests"){
	        steps{
	            bat 'mvn clean install'
	        }
        }
        stage("Sonar"){
			steps{
				bat 'mvn sonar:sonar'            
			}
        }
        stage("Sonar Quality Gate Check"){
			steps{
				timeout(time: 5, unit: 'MINUTES') {
	            	def qualityGate = waitForQualityGate()
	                if (qualityGate.status != 'OK') {
	                   	currentBuild.result = 'UNSTABLE'
	                }
            	}			    
			}
        }
        stage("Deployment"){
	        steps{
	      		bat 'mvn deploy'
	        }
        }
    }
    
    post{
		always{
			junit '**/target/surefire-reports/**/*.xml'
		}
	}
}
