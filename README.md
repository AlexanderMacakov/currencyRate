<h1 align="center">Currency Rate</h1>
<h2 align="center">

### The service returns gif depending on the exchange rate for the previous day

## Installation

```bash
git clone https://github.com/AlexanderMacakov/currencyRate.git
cd currencyRate
.\gradlew bootRun
```

###Run Docker 
```bash
.\gradlew build
docker docker build -t currencyrate:1.0.0 .
docker docker run -d -p 8080:8080 -t currencyrate:1.0.0
```


