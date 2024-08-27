import { registerPlugin } from '@capacitor/core';

import type { NetworkTypePlugin } from './definitions';

const NetworkType = registerPlugin<NetworkTypePlugin>('NetworkType', {
  web: () => import('./web').then(m => new m.NetworkTypeWeb()),
});

export * from './definitions';
export { NetworkType };
