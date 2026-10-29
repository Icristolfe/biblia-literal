# Bíblia Offline — Android

Leitor bíblico Android que funciona offline, com navegação por livro e capítulo, pesquisa e estudo dos versículos.

## Versões incluídas

- **PT-BR**: Bíblia Portuguesa Mundial. Ao tocar em um versículo, o app mostra o texto literal e os tokens do original, um card por palavra, com transliteração e gloss lexical isolado.
- **Literal**: tradução literal. Ao tocar em um versículo, o app mostra somente as referências cruzadas daquele versículo.

Palavras auxiliares marcadas com colchetes no corpus, como `[era]`, são exibidas sem os colchetes.

## Gerar o APK

Com o Android SDK instalado, execute:

```powershell
./gradlew.bat assembleDebug
```

O APK de depuração fica em `app/build/outputs/apk/debug/app-debug.apk`. Uma cópia para instalação está em `release/BibliaOffline.apk`.

## Instalar

Transfira `release/BibliaOffline.apk` para o Android e abra o arquivo para instalar. Como é uma versão de depuração, o Android pode pedir autorização para instalar apps dessa origem.

## Conteúdo

O corpus bíblico offline está em `app/src/main/assets/content/bible-data.js`; os tokens lexicais são divididos por livro em `app/src/main/assets/content/tokens/` e carregados conforme necessário. As transliterações e glosses lexicais vêm dos dados TAHOT/TAGNT do [STEP Bible](https://stepbible.org/), licença CC BY 4.0. Os glosses estão em inglês e não representam um alinhamento palavra a palavra da tradução portuguesa. As traduções mantêm suas licenças e créditos de origem; eles também são exibidos no painel de pesquisa do aplicativo.
