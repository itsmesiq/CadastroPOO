Coloque as screenshots em imagens/.
Edite relatorio.md e os dados da capa em template.tex.

Geração:
pandoc relatorio.md \
    --template=template.tex \
    --pdf-engine=xelatex \
    -o relatorio.pdf
