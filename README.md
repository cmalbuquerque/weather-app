# WeatherApp

A aplicação implementada tem como principal objetivo mostrar ao seu utilizador a previsão da meteorologia para uma dada cidade.
Para isso, recorreu-se ao uso da API do IPMA (Instituto Português do Mar e Atmosfera) que disponibiliza gratuitamente dados confiaveis da previsão meteorologica até 5 dias.

<p align="center">
  <img src="screenshot.png" height="400">
</p>

## Funcionalidades

- Visualização do estado atual do tempo para o próprio dia assim como temperatura máxima e mínima 
- Visualização da probabilidade de percipitação e direção do vento
- Previsões meteorológicas para os dias seguintes, apresentando para cada dia, o estado do tempo através de uma imagem, as máximas e as minimas


## Aquitectura
A aplicação tem a seguinte arquitetura de implementação, sendo que o repositório (WeatherRepository) gere como é que os dados são obtidos, ou seja, se vai buscar à API ou à base de dados local.
Recorreu-se ao tutorial [The Missing Google Sample of Android “Architecture Components” Guide](https://proandroiddev.com/the-missing-google-sample-of-android-architecture-components-guide-c7d6e7306b8f) para perceber o funcionamento do repositório e a gestão da obtenção de dados,
e ainda à [Lesson 14 do Android Developer Advanced Course Practicals](https://google-developer-training.github.io/android-developer-advanced-course-practicals/unit-6-working-with-architecture-components/lesson-14-room,-livedata,-viewmodel/14-1-a-room-livedata-viewmodel/14-1-a-room-livedata-viewmodel.html)

<p align="center">
  <img src="arquitetura.png" height="400">
</p>


- A ligação à API do IPMA e a obtenção dos seus dados: usando Retrofit2 e GSON
- Criação da base de dados local: em SQLite usando Room
- ViewModel usando LiveData


## Cuidados
É necessária uma ligação à internet num primeiro uso para que sejam guardados no repositório os dados provenientes da API, e ainda ter o cuidado de todos os dias garantir esta ligação para existir uma atualização dos dados das previsões dos próximos dias.

## Autoria
Carolina Albuquerque
