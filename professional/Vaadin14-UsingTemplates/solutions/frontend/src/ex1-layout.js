import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';
class Ex1LayoutTemplate extends PolymerElement {
  static get template() {
    return html`
   <h1>I'm Header</h1>
 
   <div id="contentArea"></div> 

   <h1>I'm Footer</h1> 
`;
  }

  static get is() { return 'ex1-layout' }
}
customElements.define(Ex1LayoutTemplate.is, Ex1LayoutTemplate);

