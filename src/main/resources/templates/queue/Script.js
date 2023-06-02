(function($){
    var initialContainer = $('.columns'),
        columnItems = $('.columns li'),
        columns = null,
        column = 1; // account for initial column
    function updateColumns(){
        column = 0;
        columnItems.each(function(idx, el){
            if (column > columns.length){
                column = 0;
            }
            $(columns.get(column)).append(el);
            column += 1;
        });
    }
    function setupColumns(){
        columnItems.detach();
        while (column++ < initialContainer.data('columns')){
            initialContainer.clone().insertBefore(initialContainer);
            column++;
        }
        columns = $('.columns');
    }


    $(function(){
        setupColumns();
        updateColumns();
    });
})(jQuery);
