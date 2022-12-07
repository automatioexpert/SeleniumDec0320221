/* tslint:disable */
/**
 * This is an autogenerated file created by the Stencil compiler.
 * It contains typing information for all components that exist in this project.
 */


import { HTMLStencilElement, JSXBase } from '@stencil/core/internal';
import { JSX } from '@stencil/core';


export namespace Components {
  interface HelloWorld {}
  interface MyComponent {
    /**
    * The first name
    */
    'first': string;
    /**
    * The last name
    */
    'last': string;
    /**
    * The middle name
    */
    'middle': string;
  }
}

declare namespace LocalJSX {
  interface HelloWorld extends JSXBase.HTMLAttributes {}
  interface MyComponent extends JSXBase.HTMLAttributes {
    /**
    * The first name
    */
    'first'?: string;
    /**
    * The last name
    */
    'last'?: string;
    /**
    * The middle name
    */
    'middle'?: string;
  }

  interface ElementInterfaces {
    'HelloWorld': Components.HelloWorld;
    'MyComponent': Components.MyComponent;
  }

  interface IntrinsicElements {
    'HelloWorld': LocalJSX.HelloWorld;
    'MyComponent': LocalJSX.MyComponent;
  }
}
export { LocalJSX as JSX };

declare module "@stencil/core" {
  export namespace JSX {
    interface ElementInterfaces extends LocalJSX.ElementInterfaces {}
    interface IntrinsicElements extends LocalJSX.IntrinsicElements {}
  }
}

declare global {


  interface HTMLHelloWorldElement extends Components.HelloWorld, HTMLStencilElement {}
  var HTMLHelloWorldElement: {
    prototype: HTMLHelloWorldElement;
    new (): HTMLHelloWorldElement;
  };

  interface HTMLMyComponentElement extends Components.MyComponent, HTMLStencilElement {}
  var HTMLMyComponentElement: {
    prototype: HTMLMyComponentElement;
    new (): HTMLMyComponentElement;
  };
  interface HTMLElementTagNameMap {
    'hello-world': HTMLHelloWorldElement
    'my-component': HTMLMyComponentElement
  }

  interface ElementTagNameMap {
    'hello-world': HTMLHelloWorldElement;
    'my-component': HTMLMyComponentElement;
  }
}

