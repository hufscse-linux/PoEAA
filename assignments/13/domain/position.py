import mapper
class Position(object):
    def __repr__(self):
        return "<Position(title= %s) >" %(self.title)

    def __exit__(self):
        # FIXME add sync logic 
        # this method can be used with `with` keyword
        pass

if __name__ == "__main__":
    t = mapper.get_cls(Position, "Position", 1, "PositionId")
    print t.PositionId
    print t.Title
