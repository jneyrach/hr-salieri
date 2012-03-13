package myfirstcomponent
{
    import mx.core.UIComponent;
    import flash.display.Graphics;
    import flash.display.Sprite;
    import flash.display.Shape;
    



    public class MyFirstComponent extends UIComponent
    {
        private static const DEFAULT_HEIGHT :Number = 200;
        private static const DEFAULT_WIDTH :Number = 200;

    
        public function MyFirstComponent()
        {

            super();
        }
    
        override protected function createChildren():void
        {

            super.createChildren();
        }
    
        override protected function measure():void
        {

            super.measure();

            measuredMinHeight = measuredHeight = DEFAULT_HEIGHT;
            measuredMinWidth  = measuredWidth  = DEFAULT_WIDTH;
        }

        override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void
        {

            super.updateDisplayList(unscaledWidth, unscaledHeight);
            
            
            var x:int = 5;
            var y:int = 5;


            var roundSquare:Shape = new Shape();

            roundSquare.graphics.lineStyle(0, 0x000099, 1, true);
            roundSquare.graphics.beginFill(0x0099CC);
            roundSquare.graphics.drawRoundRect(x, y, 250, 250, 10, 10);
            roundSquare.graphics.endFill();

            addChild(roundSquare);
	}

    }
}
