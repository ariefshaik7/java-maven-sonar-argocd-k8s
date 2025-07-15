# Java Spring Boot CI/CD with Jenkins, SonarQube, Docker, Kubernetes & ArgoCD

![Image](https://github.com/user-attachments/assets/a664a515-6abc-4f11-b675-ee74b62545a0)

This project demonstrates a complete DevOps workflow using a Java Spring Boot application with CI/CD pipeline powered by Jenkins, SonarQube, Docker, Kubernetes, and ArgoCD.

---

## Tools Used

| Tool | Purpose |
| --- | --- |
| Spring Boot | Web application framework |
| Jenkins | CI/CD automation |
| SonarQube | Code quality and static analysis |
| Docker | Containerization |
| Kubernetes | Application deployment and scaling |
| ArgoCD | GitOps-based continuous delivery |
| GitHub | Code and deployment manifest hosting |
| Docker Hub | Container image registry |

---

##  Step-by-Step Setup Instructions

### 1. Install Jenkins

```bash
sudo apt update
sudo apt install openjdk-17-jdk -y
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
sudo sh -c 'echo deb https://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
sudo apt update
sudo apt install jenkins -y
sudo systemctl enable jenkins
sudo systemctl start jenkins
```

Access Jenkins at `http://<ip>:8080`. To get the password:

```bash
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```

Install suggested plugins and also install:

* Docker Pipeline
    
* SonarQube Scanner
    
* GitHub Plugin
    

---

### 2\. Install Docker

```bash
sudo apt install docker.io -y
sudo systemctl enable docker
sudo systemctl start docker
sudo usermod -aG docker jenkins
sudo systemctl restart jenkins
```

---

### 3\. Install SonarQube

```bash
sudo apt update
sudo apt install openjdk-17-jdk unzip wget -y
sudo adduser sonarqube
cd /opt
sudo wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-9.9.4.87374.zip
sudo unzip sonarqube-9.9.4.87374.zip
sudo mv sonarqube-9.9.4.87374 sonarqube
sudo chown -R sonarqube:sonarqube /opt/sonarqube
sudo chmod -R 775 /opt/sonarqube
sudo su -s /bin/bash sonarqube
cd /opt/sonarqube/bin/linux-x86-64/
./sonar.sh start
./sonar.sh status
```

Access SonarQube at `http://<ip>:9000` and log in using `admin/admin`. Create a project and generate a token.

---

### 4\. Add Credentials in Jenkins

Go to **Manage Jenkins &gt; Credentials &gt; Global &gt; Add Credentials**:

* **GitHub**: Username + Token (with repo access)
    
* **Docker Hub**: Username + Docker token
    
* **SonarQube**: Secret text (Sonar token)
    

---

### 5\. Install Kubernetes CLI and Start Cluster

```bash
curl -LO "https://dl.k8s.io/release/$(curl -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
chmod +x kubectl
sudo mv kubectl /usr/local/bin/
```

Start your Kubernetes cluster using your preferred method.

---

### 6\. Install and Configure ArgoCD

```bash
kubectl create namespace argocd
kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
kubectl patch svc argocd-server -n argocd -p '{"spec": {"type": "NodePort"}}'
kubectl get svc argocd-server -n argocd
```

Get ArgoCD password and access it from the browser:

```bash
kubectl get secret -n argocd
kubectl edit secret argocd-initial-admin-secret -n argocd
echo <password> | base64 --decode
```

---

### 7\. Configure ArgoCD Application

Use the UI to configure an application:

* Git Repo: Link to your repo
    
* Path: `springboot-app-manifests`
    
* Namespace: default
    
* Sync: Auto or Manual
    

Ensure the service in `service.yml` is of type `NodePort` to allow browser access.

---

## Jenkins Pipeline Flow

1. Pull code from GitHub
    
2. Run SonarQube analysis
    
3. Build app using Maven
    
4. Build Docker image and push to Docker Hub
    
5. Update `deployment.yml` with new image
    
6. Push updated YAMLs to GitHub
    
7. ArgoCD detects changes and deploys the app
    

---

### This project demonstrates a complete end-to-end DevOps CI/CD pipeline for a Java Spring Boot web application using Jenkins, SonarQube, Docker, Kubernetes, ArgoCD.