const CACHE_NAME = 'invest-v11-no-cache';
self.addEventListener('install', e => self.skipWaiting());
self.addEventListener('activate', e => e.waitUntil(caches.keys().then(ks => Promise.all(ks.map(k => caches.delete(k)))).then(() => self.clients.claim())));
self.addEventListener('fetch', e => {
    // Force network for the main page to ensure updates
    if (e.request.mode === 'navigate') {
        return e.respondWith(fetch(e.request));
    }
    e.respondWith(caches.match(e.request).then(r => r || fetch(e.request)));
});