using System.Linq;

namespace day4;

public class BingoSubSystem
{
    private readonly string[] _data;
    private int[] _drawNumbers;
    private List<BingoBoard> _boards = new();
    private BingoBoard _winningBoard;

    public BingoSubSystem(string inputFile)
    {
        _data = File.ReadAllLines(inputFile);
        ProcessInput();
        MarkNumbers();
    }

    public BingoBoard? WinningBoard => _winningBoard;

    private void ProcessInput()
    {
        var strings = _data[0].Split(",");
        _drawNumbers = Array.ConvertAll(strings, int.Parse);

        int fromIndex = 2;
        while (fromIndex < _data.Length)
        {
            var board = FillABoard(fromIndex);
            _boards.Add(board);
            fromIndex += 6;
        }
    }

    private BingoBoard FillABoard(int fromIndex)
    {
        BingoBoard board = new(5);
        for (var i = 0; i < 5; i++)
        {
            board.AddRow(_data[fromIndex + i]);
        }

        return board;
    }

    private void MarkNumbers()
    {
        BingoBoard? winningBingoBoard = null;
        var drawNumberIndex = 0;
        do
        {
            var actualDrawNumber = _drawNumbers[drawNumberIndex];
            foreach (var bingoBoard in _boards)
            {
                bingoBoard.Mark(actualDrawNumber);
                winningBingoBoard = winningBingoBoard == null && bingoBoard.IsWinning ? bingoBoard : winningBingoBoard;
            }
            drawNumberIndex++;
        } while (winningBingoBoard == null && drawNumberIndex < _drawNumbers.Length);

        _winningBoard = winningBingoBoard;
    }
}