import { WebPlugin } from '@capacitor/core';
import type { NetworkTypePlugin } from './definitions';

export class NetworkTypeAndroid extends WebPlugin implements NetworkTypePlugin {
  async getNetworkType(): Promise<{ networkType: string }> {
    console.log('Running on the web, returning default value');
    return { networkType: 'Unknown' };
  }

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO on Android', options);
    return options;
  }
}

// import { Plugins } from '@capacitor/core';
// import type { NetworkTypePlugin } from './definitions';

// const { NetworkType } = Plugins;

// export class NetworkTypeAndroid implements NetworkTypePlugin {
//   async getNetworkType(): Promise<{ networkType: string }> {
//     try {
//       const { networkType } = await NetworkType.getNetworkType();
//       return { networkType };
//     } catch (error) {
//       console.error('Failed to get network type:', error);
//       return { networkType: 'Unknown' };
//     }
//   }
// }
