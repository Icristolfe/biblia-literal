# Bíblia Literal — projeto web independente

Este diretório contém o site/PWA para publicar no Netlify, separado do app Android e do projeto Django. Ele já inclui os arquivos estáticos e o corpus bíblico, sem depender de Python, Gradle, backend, variáveis de ambiente ou etapa de build.

## Publicar no Netlify

Envie o repositório ao GitHub e importe-o no Netlify. Configure o diretório base como `netlify-app`. O `netlify.toml` já informa para publicar o próprio diretório (`.`), sem comando de build.

Também é possível testar localmente com um servidor estático:

```powershell
cd netlify-app
py -3 -m http.server 8000
```

Abra `http://localhost:8000`. Para testar o modo offline/PWA, acesse por `localhost` ou HTTPS.

A interface é mobile-first e adapta-se a tablets e computadores. Na leitura literal, a pronúncia aproximada do original é agrupada acima da frase em português correspondente. O alinhamento é aproximado porque os dados disponíveis não incluem correspondência palavra a palavra. O service worker tenta guardar o site e o corpus para leitura offline depois do primeiro acesso online.

O corpus completo ocupa cerca de 31 MB. Consulte os créditos e licenças em [CRÉDITOS.md](CRÉDITOS.md).
