# global-hack-vi


push to prod: 

mvn -f global-hack/pom.xml clean package docker:build -DpushImage


push to kevin tag:

mvn -f global-hack/pom.xml clean package docker:build

docker push seanprobb/global-hack:kevin

