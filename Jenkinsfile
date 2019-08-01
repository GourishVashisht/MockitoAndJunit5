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
    	class: 'GitSCM',
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
    }
}

