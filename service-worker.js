const CACHE_VERSION = "biblia-literal-v4";
const SHELL = ["/", "/static/reader.css", "/static/reader.js", "/static/manifest.webmanifest", "/static/icon.svg"];

self.addEventListener("install", event => {
  event.waitUntil(caches.open(CACHE_VERSION).then(cache => cache.addAll(SHELL)).then(() => self.skipWaiting()));
});

self.addEventListener("activate", event => {
  event.waitUntil(caches.keys().then(keys => Promise.all(keys.filter(key => key.startsWith("biblia-literal-") && key !== CACHE_VERSION).map(key => caches.delete(key)))).then(() => self.clients.claim()));
});

self.addEventListener("fetch", event => {
  const request = event.request;
  const url = new URL(request.url);
  if (request.method !== "GET" || url.origin !== self.location.origin) return;

  if (request.mode === "navigate") {
    event.respondWith(fetch(request).then(response => {
      const copy = response.clone();
      caches.open(CACHE_VERSION).then(cache => cache.put("/", copy)).catch(() => {});
      return response;
    }).catch(async () => (await caches.match("/")) || (await caches.match("/index.html")) || Response.error()));
    return;
  }

  if (url.pathname === "/static/content/bible-data.js" || SHELL.includes(url.pathname)) {
    event.respondWith(caches.match(request).then(cached => {
      if (cached) return cached;
      return fetch(request).then(response => {
        if (response.ok) {
          const copy = response.clone();
          caches.open(CACHE_VERSION).then(cache => cache.put(request, copy)).catch(() => {});
        }
        return response;
      });
    }));
  }
});
