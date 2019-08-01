pipeline{
    agent any
    stages{
	    stage('Clean'){
	        steps{
	            deleteDir()
	        }
	    }
	    stage('Checkout'){
	        steps{
	         checkout([
	         	$class: 'GitSCM',
	         	branches: [[name: '*/master']],
	         	doGenerateSubmoduleConfigurations: false,
	         	extensions: [],
	         	submoduleCfg: [],
	         	userRemoteConfigs: [[
	         		credentialsId: '4f93456d-1a0a-4c3c-9245-50fc6fe265d7',
	         		url: 'https://github.com/GourishVashisht/MockitoAndJunit5.git'
	         		]
	         	]])
	        }
    	}
    	stage('Build'){
    		steps{
    		    sh label: '', script: '/usr/local/src/apache-maven/bin/mvn clean install'
    		}
    	}
    	/*stage('sonar'){
    	    steps{
    	        sh label: '', script: '/usr/local/src/apache-maven/bin/mvn sonar:sonar'
    	    }
    	}*/
    	stage('Archiver'){
    		steps{
    		    archiveArtifacts 'target/*.jar'
    		}
    	}
    }
}

