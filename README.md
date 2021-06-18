<h1 align="center">Currency Rate</h1>
<h2 align="center">

### The service returns gif depending on the exchange rate for the previous day

## Installation

```bash
git clone https://github.com/AlexanderMacakov/currencyRate.git
cd currencyRate
.\gradlew bootRun
```
Open `http://localhost:8080/`

###Run Docker 
```bash
.\gradlew build
docker build -t currencyrate:1.0.0 .
docker run -d -p 8080:8080 -t currencyrate:1.0.0
```
Open `http://localhost:8080/`


