const CACHE_NAME = 'invest-master-v5.8.3-ULTRA-FORCE';
const assets = ['./index.html', './manifest.json'];
self.addEventListener('install', (e) => {
  self.skipWaiting();
  e.waitUntil(caches.open(CACHE_NAME).then((c) => c.addAll(assets)));
});
self.addEventListener('activate', (e) => {
  e.waitUntil(caches.keys().then((keys) => Promise.all(
    keys.map((k) => k !== CACHE_NAME && caches.delete(k))
  )));
});
self.addEventListener('fetch', (e) => e.respondWith(
  fetch(e.request).catch(() => caches.match(e.request))
));