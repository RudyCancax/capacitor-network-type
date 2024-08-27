import { WebPlugin } from '@capacitor/core';
import type { NetworkTypePlugin } from './definitions';

export class NetworkTypeWeb extends WebPlugin implements NetworkTypePlugin {
  async getNetworkType(): Promise<{ networkType: string }> {
    console.log('Running on the web, returning default value');
    return { networkType: 'Unknown' };
  }
}

// import { WebPlugin } from '@capacitor/core';

// import type { NetworkTypePlugin } from './definitions';

// export class NetworkTypeWeb extends WebPlugin implements NetworkTypePlugin {
//   async echo(options: { value: string }): Promise<{ value: string }> {
//     console.log('ECHO', options);
//     return options;
//   }
// }
