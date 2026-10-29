# Créditos e licenças do conteúdo

- **Bíblia Portuguesa Mundial (BPM)**: domínio público. Fonte: [eBible.org, PORBSL](https://ebible.org/details.php?id=porbrbsl), edição de 2026-10-08. O texto é um rascunho em revisão.
- **Tradução literal do original (OWB-L)**: CC0. Fonte: [Open Word Bible](https://openwordbible.org/pt/download/).
- **Tokens hebraicos e gregos, transliterações e glosses lexicais**: dados TAHOT/TAGNT de [STEPBible.org](https://stepbible.org/), baseados em trabalho da Tyndale House Cambridge, sob [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/). As transliterações romanizadas são copiadas da fonte STEP. Os glosses ingleses são usados somente internamente no alinhamento automático e não são exibidos na interface.

As duas traduções usadas pelo aplicativo estão incluídas em `static/content/bible-data.js` e funcionam offline, sem chamadas a APIs. Os tokens lexicais são fornecidos por arquivos locais separados por livro.

O pacote OWB identifica seu texto literal como rascunho assistido por IA pendente de revisão humana ([status de revisão](https://openwordbible.org/about/status/)). O alinhamento entre esses trechos em português e os tokens STEP é automático e não revisado; os testes garantem consistência estrutural e textual, não validação linguística humana. Gênesis 1:1 segue a ordem de leitura em português e mantém cada pronúncia vinculada ao token-fonte correspondente. Quando não há texto ou token fonte, o aplicativo não inventa uma tradução ou pronúncia.
